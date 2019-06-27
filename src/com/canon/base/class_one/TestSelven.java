package com.canon.base.class_one;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: canon
 * @Date: 2018/10/30 10:42
 * @Description: 测试算法正确性
 */
public class TestSelven {

    public static void main(String[] args) {
        Map<Integer, String> map = getfMap();
        System.out.println(map);
    }
    @Deprecated
    static Map<Integer, String> getfMap() {
        Map<Integer, String> map = new HashMap<Integer, String>();
        List<Demo> demos = buildParam();

        int point = 0;
        String status = null;
        Integer fid = demos.get(0).getfId();
        for (Demo d : demos) {
            Integer f = d.getfId();
            String dStatus = d.getStatus();

            // 前置刷新
            if (!fid.equals(f)) {
                point = 0;
                fid = d.getfId();
            }

            if (fid.equals(f)) {
               map.put(fid, dStatus);

            }

        }

        return map;
    }

    private static List<Demo> buildParam() {
        List<Demo> list = new ArrayList<Demo>();
        list.add(new Demo(1,"1",1));
        list.add(new Demo(2,"1",1));
        list.add(new Demo(3,"1",1));
        list.add(new Demo(4,"1",2));
        list.add(new Demo(5,"1",2));
        list.add(new Demo(6,"1",3));
        list.add(new Demo(7,"1",4));
        list.add(new Demo(8,"1",5));
        list.add(new Demo(9,"1",5));
        list.add(new Demo(10,"1",6));

        return list;
    }

}

/**
 * 测试类数据结构,构造
 */
class Demo {
    private Integer id;
    private String status;
    private Integer fId;

    public Demo(Integer id, String status, Integer fId) {
        this.id = id;
        this.status = status;
        this.fId = fId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }
}
