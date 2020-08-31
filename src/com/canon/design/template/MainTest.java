package com.canon.design.template;

/**
 * @PackageName: com.canon.design.template
 * @Description: 测试
 * @author: canon
 * @date: 2020/5/27 10:38
 * @Version: 1.0
 */
public class MainTest {
    public static void main(String[] args) {
        Template template = new Template();
        template.init();
        template.doThings(1);
        template.doThings(2);
        template.doThings(3);
    }
}
