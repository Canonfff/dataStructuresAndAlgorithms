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
        return null;
    }

    @Override
    ActionEnum getAction() {
        return ActionEnum.delete;
    }
}
