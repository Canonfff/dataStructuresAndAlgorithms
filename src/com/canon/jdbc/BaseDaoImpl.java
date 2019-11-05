package com.canon.jdbc;

import com.canon.jdbc.builder.Sql;
import com.canon.jdbc.handler.SqlHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/6/24 17:56
 * @Description:
 */
public class BaseDaoImpl<T> implements BaseDao<T> {

    private SqlHandler<T> sqlHandler = new SqlHandler<T>();

    private Class<T> entityClass;

    public BaseDaoImpl() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type actualTypeArgument = type.getActualTypeArguments()[0];
        entityClass = (Class<T>) actualTypeArgument;
        System.out.println(entityClass);
    }

    @Override
    public int save(T t) {
        Sql save = sqlHandler.save(t);
        System.out.println(save);
        return 0;
    }

    @Override
    public int update(T t) {
        Sql sql = sqlHandler.update(t);
        System.err.println(sql);
        return 0;
    }

    @Override
    public int delete(T t) {
        Sql sql = sqlHandler.delete(t);
        System.err.println(sql);
        return 0;
    }


    @Override
    public T selectByPrimaryKey(Object o) {
        Sql sql = sqlHandler.selectByPrimaryKey(entityClass, o);
        System.err.println(sql);
        return null;
    }

    @Override
    public List<T> selectByParam(Map<String, Object> map) {
        Sql sql = sqlHandler.selectByParam(entityClass, map);
        System.err.println(sql);
        return null;
    }

}
