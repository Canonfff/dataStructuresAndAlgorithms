package com.canon.jdbc.builder;

import com.canon.jdbc.ActionEnum;
import com.canon.jdbc.AnnotationEnum;
import com.canon.jdbc.PrimaryKey;
import com.canon.jdbc.Table;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/6/25 10:06
 * @Description: SQL建造者
 */
public abstract class SqlBuilder {
    protected static String table = "table";
    protected static String field = "field";


    public abstract Sql build(Class clazz, Map<String, Object> param);

    abstract ActionEnum getAction();

    /**
     * 获取表名
     *
     * @param entityClass
     * @return
     */
    protected String getTableName(Class entityClass) {
        Table table = (Table) entityClass.getAnnotation(AnnotationEnum.table.clazz);
        if (table == null || table.value() == null || "".equals(table.value().trim())) {
            return entityClass.getSimpleName();
        }
        return table.value();
    }

    /**
     * 获取非主键字段
     *
     * @param entityClass
     * @return
     */
    protected List<String> getFields(Class entityClass) {
        Field[] fields = entityClass.getDeclaredFields();
        List<String> list = new ArrayList<String>();
        SqlDirector.notNull(fields, "class field must not be null");
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                com.canon.jdbc.Field annotation = (com.canon.jdbc.Field) field.getAnnotation(AnnotationEnum.field.clazz);
                if (annotation != null) {
                    String anntationV = annotation.value();
                    String fieldName = (anntationV == null || "".equals(anntationV.trim())) ? field.getName() : anntationV;
                    list.add(fieldName);
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("获取字段信息失败", e);
        }
        if (list.isEmpty()) {
            throw new IllegalArgumentException("class field annotation must not be null");
        }
        return list;
    }

    /**
     * 获取主键字段
     * @param entityClass
     * @return
     */
    protected String getPrimaryKey(Class entityClass) {
        Field[] fields = entityClass.getDeclaredFields();
        scan: {
            for (Field field : fields) {
                field.setAccessible(true);
                PrimaryKey annotation = (PrimaryKey) field.getAnnotation(AnnotationEnum.primaryKey.clazz);
                if (annotation != null) {
                    String anntationV = annotation.value();
                    String fieldName = (anntationV == null || "".equals(anntationV.trim()))
                            ? field.getName() : anntationV;
                    return fieldName;
                }
            }
            throw new IllegalArgumentException("class can not fouond primaryKey annotation");
        }
    }

    /**
     * 获取默认的SQL
     * @return
     */
    protected String getDefaultSql() {
        return getAction().value;
    }

    /**
     * 获取默认的SQL
     * @param clazz
     * @return
     */
    protected String getDefaultSql(Class clazz) {
        return getDefaultSql().replaceAll(table,getTableName(clazz));
    }

    /**
     * 获取字段,不含主键(逗号分割)
     * @param clazz
     * @return
     */
    protected String getField(Class clazz) {
        StringBuffer sb = new StringBuffer();
        List<String> fields = getFields(clazz);
        for (String s : fields) {
            sb.append(s);
            sb.append(",");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        return sb.toString();
    }

    /**
     * 获取所有字段(逗号分割)
     * @param clazz
     * @return
     */
    protected String getAllField(Class clazz) {
        String field = getField(clazz);
        return field += (","+getPrimaryKey(clazz));
    }
}
