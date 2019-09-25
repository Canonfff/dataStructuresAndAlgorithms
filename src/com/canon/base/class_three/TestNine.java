package com.canon.base.class_three;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/7/29 16:57
 * @Description:测试多态
 */
public class TestNine {
    public static void main(String[] args){
        Manager[] managers = new Manager[10];
        Employee[] staff1 = (Employee[])managers;
        Employee employee = (Employee) staff1[0];
        employee = new Employee("Carl Cracker", 80000, 1987, 12, 15);
        // managers[0].setBonus("1000");
    }
}
class Employee{
    private String name;
    private int a;
    private int b;
    private int c;
    private int d;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public Employee(String name, int a, int b, int c, int d) {
        this.name = name;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public Employee() {
    }
}
class Manager extends Employee{
    private String bonus;

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }
}