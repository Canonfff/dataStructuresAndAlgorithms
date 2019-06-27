package com.canon.jdbc.builder;

import com.canon.jdbc.ActionEnum;

import java.util.Map;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/6/25 10:05
 * @Description: SQL建造指挥者
 */
public class SqlDirector {
    // @Autowired(required = false) 使用spring自动注入的方式
    private SqlBuilder[] builders = new  SqlBuilder[] {new InsertBuilder(),new DeleteBuilder(),new UpdateBuilder(),new SelectBuilder()};

    public Sql construct(ActionEnum action, Class clazz, Map<String, Object> param) {
        return getBuilder(action).build(clazz,param);
    }

    public SqlBuilder getBuilder(ActionEnum action) {
        notNull(action,"ActionEnum must can not be null");
        notNull(builders, "can not found builders impl class");
        for (SqlBuilder builder : builders) {
            if (action.equals(builder.getAction())) {
                return builder;
            }
        }
        throw new IllegalArgumentException("ActionEnum can not found builder [" + action + "]");
    }
    public static void notNull(Object o, String msg) {
        if (o == null) {
            throw new IllegalArgumentException(msg);
        }
    }
}
