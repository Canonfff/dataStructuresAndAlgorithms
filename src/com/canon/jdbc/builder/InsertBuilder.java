package com.canon.jdbc.builder;

import com.canon.jdbc.ActionEnum;

import java.util.Map;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/6/25 10:34
 * @Description:
 */
public class InsertBuilder extends SqlBuilder {

    @Override
    public Sql build(Class clazz, Map<String, Object> param) {
        String sql = getDefaultSql(clazz);
        StringBuffer sb = new StringBuffer("(");
        StringBuffer sb2 = new StringBuffer("(");
        Object[] params = new Object[param.size()];
        int count = 0;
        for (Map.Entry<String, Object> entry : param.entrySet()) {
            sb.append(entry.getKey());
            sb.append(",");
            sb2.append("?");
            sb2.append(",");
            params[count++] = entry.getValue();
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb2.deleteCharAt(sb2.lastIndexOf(","));
        sb.append(")");
        sb2.append(")");
        sql += sb.toString() + sb2.toString();
        return new Sql(sql,params);
    }

    @Override
    ActionEnum getAction() {
        return ActionEnum.insert;
    }
}
