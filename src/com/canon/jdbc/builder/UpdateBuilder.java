package com.canon.jdbc.builder;

import com.canon.jdbc.ActionEnum;
import com.canon.jdbc.utils.SqlUtil;

import java.util.Map;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/6/25 10:33
 * @Description:
 */
public class UpdateBuilder extends SqlBuilder {
    @Override
    public Sql build(Class clazz, Map<String, Object> param) {
        String sql = getDefaultSql(clazz);
        StringBuffer sb = new StringBuffer();
        StringBuffer sb2 = new StringBuffer(where);
        Object[] params = new Object[param.size()];
        Object primaryKey = null;
        int count = 0;
        for (Map.Entry<String, Object> entry : param.entrySet()) {
            if (SqlUtil.getPrimaryKey(clazz).equals(entry.getKey())) {
                sb2.append(entry.getKey() + "=? ");
                primaryKey = entry.getValue();
                continue;
            }
            sb.append(entry.getKey() + "=?, ");
            params[count++] = entry.getValue();
        }
        params[count] = primaryKey;
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append(sb2);
        sql += sb.toString();
        return new Sql(sql, params);
    }

    @Override
    ActionEnum getAction() {
        return ActionEnum.update;
    }
}
