package com.canon.jdbc.handler;

import com.canon.jdbc.ActionEnum;
import com.canon.jdbc.AnnotationEnum;
import com.canon.jdbc.PrimaryKey;
import com.canon.jdbc.builder.Sql;
import com.canon.jdbc.builder.SqlDirector;
import com.canon.jdbc.utils.SqlUtil;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/6/25 11:19
 * @Description: sql处理器
 */
public class SqlHandler<T> {
    /*
     * 整理资源,作为一个桥梁与建造者调度中心连接
     */
    private SqlDirector sqlDirector = new SqlDirector();

    public Sql execute(ActionEnum action, Class clazz, Map<String, Object> param) {
        return sqlDirector.construct(action, clazz, param);
    }

    public Sql save(T t) {
        return execute(ActionEnum.insert, t.getClass(), getParam(t));
    }

    public Sql selectByPrimaryKey(Class clazz, Object o) {
        Map<String, Object> param = new HashMap<String, Object>(1);
        String primaryKey = SqlUtil.getPrimaryKey(clazz);
        param.put(primaryKey, o);
        return execute(ActionEnum.select, clazz, param);
    }

    public Sql selectByParam(Class clazz, Map<String, Object> param) {
        return execute(ActionEnum.select, clazz, param);
    }

    public Sql update(T t) {
        Map<String, Object> param = getParam(t);
        param.putAll(getPrimaryParam(t));
        return execute(ActionEnum.update, t.getClass(), param);
    }

    public Sql delete(T t) {
        return execute(ActionEnum.delete, t.getClass(), getParam(t));
    }

    /**
     * 获取参数(不含主键)
     * @param t
     * @return
     */
    private Map<String, Object> getParam(T t) {
        Field[] fields = t.getClass().getDeclaredFields();
        // key 数据库字段名 | value 字段值
        Map<String, Object> map = new HashMap<String, Object>();
        if (fields != null) {
            try {
                for (Field field : fields) {
                    field.setAccessible(true);
                    com.canon.jdbc.Field annotation = (com.canon.jdbc.Field) field.getAnnotation(AnnotationEnum.field.clazz);
                    if (annotation != null) {
                        String anntationV = annotation.value();
                        String fieldName = (anntationV == null || "".equals(anntationV.trim())) ? field.getName() : anntationV;
                        Object value = field.get(t);
                        map.put(fieldName, value);
                    }
                }
            } catch (Exception e) {
                throw new IllegalArgumentException("获取字段信息失败", e);
            }
        }
        return map;
    }

    /**
     * 获取参数(只含主键)
     * @param t
     * @return
     */
    private Map<String, Object> getPrimaryParam(T t) {
        Field[] fields = t.getClass().getDeclaredFields();
        // key 数据库字段名 | value 字段值
        Map<String, Object> map = new HashMap<String, Object>();
        if (fields != null) {
            try {
                for (Field field : fields) {
                    field.setAccessible(true);
                    PrimaryKey pAnnotation = (PrimaryKey) field.getAnnotation(AnnotationEnum.primaryKey.clazz);
                    if (pAnnotation != null) {
                        String anntationV = pAnnotation.value();
                        String fieldName = (anntationV == null || "".equals(anntationV.trim())) ? field.getName() : anntationV;
                        Object value = field.get(t);
                        map.put(fieldName, value);
                    }
                }
            } catch (Exception e) {
                throw new IllegalArgumentException("获取字段信息失败", e);
            }
        }
        return map;
    }

}
