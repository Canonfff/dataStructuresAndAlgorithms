package com.canon.jdbc.utils;

import com.canon.jdbc.AnnotationEnum;
import com.canon.jdbc.PrimaryKey;
import com.canon.jdbc.Table;
import com.canon.jdbc.builder.SqlDirector;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/6/27 18:37
 * @Description:
 */
public abstract class SqlUtil {

    /**
     * 获取表名
     *
     * @param entityClass
     * @return
     */
    public static String getTableName(Class entityClass) {
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
    public static List<String> getFields(Class entityClass) {
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
    public static String getPrimaryKey(Class entityClass) {
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
}
