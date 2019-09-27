package com.canon.design.filter;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/9/27 09:41
 * @Description:过滤器核心接口
 */
public interface Filter<T> {


    void doFilter(T t, FilterChain chain);

}
