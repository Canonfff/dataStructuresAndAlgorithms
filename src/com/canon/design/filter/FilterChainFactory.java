package com.canon.design.filter;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/9/27 09:55
 * @Description:
 */
public abstract class FilterChainFactory {

    public static FilterChain getFilterChain() {
        FilterChain chain = new FilterChainImpl();
        chain.addFilter(new OneFilter());
        return chain;
    }
}
