package com.canon.model;

/**
 * @PackageName: com.canon.model
 * @Description:
 * @author: canon
 * @date: 2020/9/1 9:05
 * @Version: 1.0
 */
public class Model {

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
