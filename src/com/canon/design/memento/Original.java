package com.canon.design.memento;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/4/17 15:04
 * @Description: 备忘录模式
 * 原始类
 */
public class Original implements Cloneable, Serializable {

    private String value;
    private String name;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String record() {
        return Storage.record(this);
    }
    public void reSet(String key) {
        Original original = Storage.reSet(key);
        set(original);
    }

    public void set(Original original) {
        if (original == null) {
            original = new Original();
        }
        this.value = original.getValue();
        this.name = original.getName();
    }

    public Original() {
    }

    public Original(String value, String name) {
        this.value = value;
        this.name = name;
    }

    /**
     * 克隆模式
     * @return
     */
    @Override
    public Original clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return (Original) clone;
    }

    /**
     * 深克隆
     * @return
     */
    public Original deepClone() {
        Object o = null;
        try {
            /* 写入当前对象的二进制流 */
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            /* 读出二进制流产生的新对象 */
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            o = ois.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return (Original) o;
    }

    @Override
    public String toString() {
        return "Original{" +
                "value='" + value + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
