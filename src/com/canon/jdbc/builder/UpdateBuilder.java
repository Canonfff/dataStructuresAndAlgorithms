package com.canon.jdbc.builder;

import com.canon.jdbc.ActionEnum;

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

        for (Map.Entry<String, Object> entry : param.entrySet()) {

        }
        return null;
    }

    @Override
    ActionEnum getAction() {
        return ActionEnum.update;
    }
}
