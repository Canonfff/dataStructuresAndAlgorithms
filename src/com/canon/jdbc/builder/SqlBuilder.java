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
     * @param clazz
     * @return
     */
    protected String getDefaultSql(Class clazz) {
        return getAction().value.replaceAll(table, SqlUtil.getTableName(clazz));
    }

}
