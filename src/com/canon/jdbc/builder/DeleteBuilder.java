package com.canon.jdbc.builder;

import com.canon.jdbc.ActionEnum;

import java.util.Map;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/6/25 10:34
 * @Description:
 */
public class DeleteBuilder extends SqlBuilder {
    @Override
    public Sql build(Class clazz, Map<String, Object> param) {
        String sql = getDefaultSql(clazz);
        StringBuffer sb = new StringBuffer(where);
        Object[] params = new Object[param.size()];
         int count = 0;
        for (Map.Entry<String, Object> entry : param.entrySet()) {
            sb.append(entry.getKey() + "=? and ");
            params[count++] = entry.getValue();
        }
        sb.delete(sb.lastIndexOf("and"),sb.length());
        sql += sb.toString();
        return new Sql(sql, params);
    }

    @Override
    ActionEnum getAction() {
        return ActionEnum.delete;
    }
}
