package com.canon.jdk.javabean;

import java.beans.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @PackageName: com.canon.jdk.javabean
 * @Description: java内省机制
 * @author: canon
 * @date: 2020/5/19 14:38
 * @Version: 1.0
 */
public class IntrospectorTest {

    public static void main(String[] args) throws Throwable {
        fn1();
    }

    static void fn1() throws Throwable {
        Supplier<IntrospectModel> supplier = IntrospectModel::new;
        IntrospectModel model = supplier.get();
        model.setName("canon");
        model.setPassword("123456");

        // 通过java的内省机制获取javaBean的属性
        BeanInfo beanInfo = Introspector.getBeanInfo(model.getClass());

        // 获取bean的描述者
        BeanDescriptor beanDescriptor = beanInfo.getBeanDescriptor();

        // 获取属性的描述者
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

        // 获取方法的描述者
        MethodDescriptor[] methodDescriptors = beanInfo.getMethodDescriptors();


        Map map = new HashMap();
        List<PropertyDescriptor> list = Arrays.asList(propertyDescriptors);
        list.forEach(property -> {
            try {
                if (!"class".equals(property.getName()))
                    map.put(property.getName(), String.valueOf(property.getReadMethod().invoke(model)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // list过滤
        list = list.stream().filter(property -> !"class".equals(property.getName())).collect(Collectors.toList());


        System.out.println(map);
        System.out.println(list);

    }
}
