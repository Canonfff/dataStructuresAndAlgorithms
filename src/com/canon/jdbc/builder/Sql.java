package com.canon.jdbc.builder;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/6/27 17:47
 * @Description:
 */
public class Sql implements Serializable {
    // 执行SQL
    private String sql;
    // 执行参数
    private Object[] param;

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public Object[] getParam() {
        return param;
    }

    public void setParam(Object[] param) {
        this.param = param;
    }

    public Sql(String sql, Object[] param) {
        this.sql = sql;
        this.param = param;
    }

    public Sql() {
    }

    @Override
    public String toString() {
        return "Sql{" +
                "sql='" + sql + '\'' +
                ", param=" + Arrays.toString(param) +
                '}';
    }
}
