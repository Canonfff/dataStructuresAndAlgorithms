package com.canon.jdbc;

import java.util.List;
import java.util.Map;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/6/24 17:32
 * @Description:
 */
public interface BaseDao<T> {

    int save(T t);

    int update(T t);

    int delete(T t);

    T selectByPrimaryKey(Object o);

    List<T> selectByParam(Map<String, Object> map);
}
