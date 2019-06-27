package com.canon.jdbc;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/6/25 14:33
 * @Description:
 */
public enum ActionEnum {
    select("查询","select field from table "),
    insert("插入","insert into table "),
    delete("删除","delete from table "),
    update("更新","update table set ");

    ActionEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String name;
    public String value;
}
