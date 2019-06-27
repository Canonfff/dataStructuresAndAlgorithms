package com.canon.jdbc;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/3/1 13:52
 * @Description:注解测试类
 */
public class Test {
    public static void main(String[] args) {
        BaseDao<Entry> baseDao = new EntryDao();
        Entry entry = new Entry();
        entry.setName("zhanzifan");
        entry.setPassword("123456");
        entry.setNickName("canon");
        entry.setBirthday(new Date());
        entry.setId("1");
        baseDao.save(entry);
        System.out.println();
        baseDao.update(entry);
        System.out.println();
        baseDao.delete(entry);
        System.out.println();
        baseDao.selectByPrimaryKey("11");
        System.out.println();
        Map<String,Object> map = new HashMap<>();
        map.put("id","1");
        map.put("name","zhanzifan");
        baseDao.selectByParam(map);
    }
}
