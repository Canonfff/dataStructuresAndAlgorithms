package com.canon.constructor.model;

import java.io.Serializable;

/**
 * @Author Canon
 * @Date:Created in 23:55 2019/10/25
 * @Modify By: canon
 * @Despricction:
 * @since 1.0
 */
public class BaseModel implements Serializable {
    private static final long serialVersionUID = 4933038301034215024L;
    BaseModel base;
    public BaseModel() {
        base = this;
    }
    public BaseModel(BaseModel baseModel) {
        baseModel.cast(this);
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void cast(BaseModel baseModel) {

    }

    @Override
    public String toString() {
        return "BaseModel{" +
                "name='" + name + '\'' +
                '}';
    }
}
