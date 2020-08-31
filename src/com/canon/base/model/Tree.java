package com.canon.base.model;

/**
 * @PackageName: com.canon.base.model
 * @Description:
 * @author: canon
 * @date: 2020/8/26 17:54
 * @Version: 1.0
 */
public class Tree {

    private Tree parent;// 父节点, 顶层节点为null

    private Tree left;// 左节点

    private Tree right;// 右节点

    private int sort;// 比sort大的放到右节点,比

    private long key;// id

    private String value;// 具体存放值

}
