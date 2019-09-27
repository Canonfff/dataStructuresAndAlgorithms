package com.canon.design.filter;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/9/27 09:51
 * @Description:
 */
public class OneFilter<Bean> implements Filter<Bean> {

    /**
     * 这里有一个递归
     * @param bean
     * @param chain
     */
    @Override
    public void doFilter(Bean bean, FilterChain chain) {
        System.out.println("OneFilter write bean");
        chain.doFilter(bean);
    }
}
