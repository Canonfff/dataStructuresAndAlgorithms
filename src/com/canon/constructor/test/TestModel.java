package com.canon.constructor.test;

import com.canon.constructor.model.BaseModel;
import com.canon.constructor.model.SubOneModel;

/**
 * @Author Canon
 * @Date:Created in 23:58 2019/10/25
 * @Modify By: canon
 * @Despricction:
 * @since 1.0
 */
public class TestModel {
    public static void main(String[] args) {
        BaseModel base = new BaseModel();
        base.setName("wocao");
        SubOneModel subOneModel = new SubOneModel(base);
        System.out.println(subOneModel);
        System.out.println(subOneModel.getName());
    }
}
