package com.canon.design.memento;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/4/17 15:07
 * @Description:备忘录类
 */
public class Memento {
    private Original original;

    public Original getOriginal() {
        return original;
    }

    public void setOriginal(Original original) {
        this.original = original;
    }

    private Memento(Original original) {
        this.original = original;
    }

    public static Memento getInstance(Original original) {
        return new Memento(original.deepClone());
    }


}
