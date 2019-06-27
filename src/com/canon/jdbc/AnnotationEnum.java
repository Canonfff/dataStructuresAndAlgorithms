package com.canon.jdbc;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/6/24 16:58
 * @Description:
 */
public enum AnnotationEnum {
    table(Table.class),
    primaryKey(PrimaryKey.class),
    field(Field.class);
    AnnotationEnum(Class clazz) {
        this.clazz = clazz;
    }
    public Class clazz;
}
