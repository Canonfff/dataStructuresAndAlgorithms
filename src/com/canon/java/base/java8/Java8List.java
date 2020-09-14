package com.canon.java.base.java8;

import com.canon.model.Model;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @PackageName: com.canon.java.base.java8
 * @Description: java8list新特性
 * @author: canon
 * @date: 2020/9/1 9:03
 * @Version: 1.0
 */
public class Java8List {
    public static void main(String[] args) {
        listReduce();
        // listConverMap();
    }

    static void listConverMap() {
        List<Model> models = getModels();

        // 获取属性
        List<Long> list = models.stream().map(Model::getId).distinct().collect(Collectors.toList());
        // 转map,
        Map<Long, String> map = models.stream().filter(e -> Objects.nonNull(e.getId())).collect(Collectors.toMap(Model::getId, Model::getName, (key1, key2) -> key2));
        Map<Long, Model> modelMap = models.stream().collect(Collectors.toMap(Model::getId, a -> a, (k1, k2) -> k2));
        // 分组
        Map<Long, List<Model>> group = models.stream().collect(Collectors.groupingBy(Model::getId));
        System.out.println(list);
        System.out.println(map);
        System.out.println(group);
        System.out.println(modelMap);
    }

    /**
     * reduce testing
     */
    static void listReduce() {
        List<Model> models = getModels();
        Optional<Model> reduce = models.stream().reduce((a, b) -> {
            a.setId(a.getId() * 10);
            b.setId(b.getId() * 10);
            return null;
        });
        if (reduce.isPresent()) {
            System.out.println(reduce.get());
        }
    }

    private static List<Model> getModels() {
        List<Model> models = new ArrayList<Model>();
        Model model = new Model();
        model.setId(1L);
        model.setName("a");
        Model model2 = new Model();
        model2.setId(2L);
        model2.setName("b");
        Model model3 = new Model();
        model3.setId(2L);
        model3.setName("c");

        models.add(model);
        models.add(model2);
        models.add(model3);
        return models;
    }

}
