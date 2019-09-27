package com.canon.design.filter;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/9/27 09:44
 * @Description:过滤链
 */
public interface FilterChain<T> {

    void doFilter(T t);

    FilterChain addFilter(Filter filter);
}
