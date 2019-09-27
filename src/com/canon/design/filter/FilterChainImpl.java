package com.canon.design.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/9/27 09:47
 * @Description:
 */
public class FilterChainImpl<T> implements FilterChain<T> {

    private List<Filter> filters = null;

    // 下一个执行器索引
    private int filterIndex = 0;

    public FilterChainImpl() {
        filters = new ArrayList<>();
    }

    @Override
    public void doFilter(T t) {
        filters.get(filterIndex ++).doFilter(t, this);
    }

    @Override
    public FilterChain addFilter(Filter filter) {
        filters.add(filter);
        return this;
    }
}
