package com.canon.jdbc;

import com.canon.jdbc.builder.Sql;
import com.canon.jdbc.handler.SqlHandler;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/6/24 17:56
 * @Description:
 */
public class BaseDaoImpl<T> implements BaseDao<T> {

    private SqlHandler<T> sqlHandler = new SqlHandler<T>();

    private Class<T> entityClass;

    public BaseDaoImpl() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type actualTypeArgument = type.getActualTypeArguments()[0];
        entityClass = (Class<T>) actualTypeArgument;
        System.out.println(entityClass);
    }

    @Override
    public int save(T t) {
        // buildSaveSql(ActionEnum.insert, t);
        Sql save = sqlHandler.save(t);
        System.out.println(save);
        return 0;
    }

    @Override
    public int update(T t) {
        buildUpdateSql(ActionEnum.update, t);
        return 0;
    }

    @Override
    public int delete(T t) {
        buildDeleteSql(ActionEnum.delete, t);
        return 0;
    }


    @Override
    public T selectByPrimaryKey(Object o) {
        buildSelectSql(ActionEnum.select, o);
        return null;
    }

    @Override
    public List<T> selectByParam(Map<String, Object> map) {
        buildSelectParamSql(ActionEnum.select, map);
        return null;
    }

    /**
     * 获取表名
     *
     * @return
     */
    public String getTableName() {
        Table table = (Table) entityClass.getAnnotation(AnnotationEnum.table.clazz);
        if (table == null || table.value() == null || "".equals(table.value().trim())) {
            return entityClass.getSimpleName();
        }
        return table.value();
    }

    /**
     * @param t
     * @return
     */
    public Map<String, Object> getFields(T t) {
        Field[] fields = entityClass.getDeclaredFields();
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

    public String buildSaveSql(ActionEnum action, T t) {
        Map<String, Object> fields = getFields(t);
        String tableName = getTableName();
        String sql = action.value;
        Object[] param = null;
        sql = sql.replaceAll("table", tableName);
        checkMap(fields);
        StringBuffer sb = new StringBuffer("(");
        StringBuffer sb2 = new StringBuffer("(");
        param = new Object[fields.size()];
        int count = 0;
        for (Map.Entry<String, Object> entry : fields.entrySet()) {
            sb.append(entry.getKey());
            sb.append(",");
            sb2.append("?");
            sb2.append(",");
            param[count++] = entry.getValue();
        }
        sb.deleteCharAt(sb.length() - 1);
        sb2.deleteCharAt(sb2.length() - 1);
        sb.append(")");
        sb2.append(")");
        sql += sb.toString() + sb2.toString();
        System.err.println("构造出来的SQL是:" + sql);
        System.err.println("构造出来的参数是:" + Arrays.toString(param));
        return null;
    }

    protected void checkMap(Map map) {
        if (map == null || map.isEmpty()) {
            throw new IllegalArgumentException("map集合为空");
        }
    }


    public String buildUpdateSql(ActionEnum action, T t) {
        Map<String, Object> fields = getFields(t);
        Map<String, Object> primaryKey = getPrimaryKey(t);
        String tableName = getTableName();
        String sql = action.value;
        Object[] param = null;
        checkMap(fields);
        sql = sql.replaceAll("table", tableName);
        if (fields != null) {
            StringBuffer sb = new StringBuffer();
            param = new Object[fields.size() + primaryKey.size()];
            int count = 0;
            for (Map.Entry<String, Object> entry : fields.entrySet()) {
                sb.append(entry.getKey() + "=? , ");
                param[count++] = entry.getValue();
            }
            sb.deleteCharAt(sb.lastIndexOf(","));
            sb.append(" where " );
            for (Map.Entry<String, Object> pEntry : primaryKey.entrySet()) {
                sb.append(pEntry.getKey() + "=?");
                param[count] = pEntry.getValue();
            }
            sql += sb.toString();
            System.err.println("构造出来的SQL是:" + sql);
            System.err.println("构造出来的参数是:" + Arrays.toString(param));
        }
        return null;
    }

    public Map<String, Object> getPrimaryKey(T t) {
        Map<String, Object> map = new HashMap<String, Object>(1);
        Field[] fields = t.getClass().getDeclaredFields();
        if (fields != null && fields.length > 0) {
            try {
                for (Field field : fields) {
                    field.setAccessible(true);
                    PrimaryKey annotation = (PrimaryKey) field.getAnnotation(AnnotationEnum.primaryKey.clazz);
                    if (annotation != null) {
                        String anntationV = annotation.value();
                        String fieldName = (anntationV == null || "".equals(anntationV.trim())) ? field.getName() : anntationV;
                        Object o = field.get(t);
                        map.put(fieldName,o);
                        return map;
                    }
                }
            }catch (Exception e) {
                throw new IllegalArgumentException("获取主键信息失败", e);
            }

        }
        throw new IllegalArgumentException("未定义主键");
    }

    private String buildDeleteSql(ActionEnum action, T t) {
        Map<String, Object> primaryKey = getPrimaryKey(t);
        String tableName = getTableName();
        String sql = action.value;
        Object[] param = null;
        checkMap(primaryKey);
        sql = sql.replaceAll("table", tableName);
        if (primaryKey != null) {
            StringBuffer sb = new StringBuffer("where ");
            param = new Object[primaryKey.size()];
            int count = 0;
            for (Map.Entry<String, Object> entry : primaryKey.entrySet()) {
                sb.append(entry.getKey() + "=?");
                param[count++] = entry.getValue();
            }
            sql += sb.toString();
            System.err.println("构造出来的SQL是:" + sql);
            System.err.println("构造出来的参数是:" + Arrays.toString(param));
        }
        return null;
    }

    private String buildSelectSql(ActionEnum action, Object o) {
        T t = buildInstance(o);
        Map<String, Object> primaryKey = getPrimaryKey(t);
        Map<String, Object> fields = getFields(t);
        fields.putAll(primaryKey);
        String tableName = getTableName();
        String sql = action.value;
        Object[] param = null;
        checkMap(primaryKey);
        sql = sql.replaceAll("table", tableName);
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, Object> entry : fields.entrySet()) {
            sb.append(entry.getKey()+",");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sql = sql.replaceAll("field", sb.toString());
        sb.setLength(0);
        sb.append("where ");
        param = new Object[primaryKey.size()];
        int count = 0;
        for (Map.Entry<String, Object> pEntry : primaryKey.entrySet()) {
            sb.append(pEntry.getKey() + "=?");
            param[count ++] = pEntry.getValue();
        }
        sql += sb.toString();
        System.err.println("构造出来的SQL是:" + sql);
        System.err.println("构造出来的参数是:" + Arrays.toString(param));
        return null;
    }
    private T buildInstance(Object o) {
        T t = null;
        try {
            t = entityClass.newInstance();
            Field[] fields = entityClass.getDeclaredFields();
            if (fields != null) {
                for (Field field : fields) {
                    field.setAccessible(true);
                    PrimaryKey annotation = (PrimaryKey) field.getAnnotation(AnnotationEnum.primaryKey.clazz);
                    if (annotation != null) {
                        field.set(t, o);
                    }
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return t;
    }
    public String buildSelectParamSql(ActionEnum action, Map<String, Object> params) {
        String tableName = getTableName();
        try {
            Map<String, Object> fields = getFields(entityClass.newInstance());
            Map<String, Object> primaryKey = getPrimaryKey(entityClass.newInstance());
            fields.putAll(primaryKey);
            checkMap(fields);
            String sql = action.value;
            sql = sql.replaceAll("table",tableName);
            Object[] param = null;
            StringBuffer sb = new StringBuffer();
            for (Map.Entry<String, Object> entry : fields.entrySet()) {
                sb.append(entry.getKey()+",");
            }
            sb.deleteCharAt(sb.lastIndexOf(","));
            sql = sql.replaceAll("field", sb.toString());
            sb.setLength(0);
            param = new Object[params.size()];
            int count = 0;
            for (Map.Entry<String, Object> pEntry : params.entrySet()) {
                sb.append(pEntry.getKey() + "=? and ");
                param[count ++] = pEntry.getValue();
            }
            sb.delete(sb.lastIndexOf("and"),sb.length());
            sql += sb.toString();
            System.err.println("构造出来的SQL是:" + sql);
            System.err.println("构造出来的参数是:" + Arrays.toString(param));
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
