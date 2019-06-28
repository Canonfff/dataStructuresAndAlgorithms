package com.canon.jdbc.builder;

import com.canon.jdbc.ActionEnum;
import com.canon.jdbc.utils.SqlUtil;

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
    protected static String where = "where ";


    public abstract Sql build(Class clazz, Map<String, Object> param);

    abstract ActionEnum getAction();







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
        return getDefaultSql().replaceAll(table, SqlUtil.getTableName(clazz));
    }

    /**
     * 获取字段,不含主键(逗号分割)
     * @param clazz
     * @return
     */
    protected String getField(Class clazz) {
        StringBuffer sb = new StringBuffer();
        List<String> fields = SqlUtil.getFields(clazz);
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
        return field += ("," + SqlUtil.getPrimaryKey(clazz));
    }
}
