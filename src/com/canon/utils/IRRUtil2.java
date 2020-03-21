package com.canon.utils;

import java.math.BigDecimal;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/10/30 14:07
 * @Description:另外一种IRR算法的实现
 */
public class IRRUtil2 {
    public static double irr(double[] values, double guess) {
        int maxIterationCount = 20;
        double absoluteAccuracy = 1.0E-007D;

        double x0 = guess;

        int i = 0;
        while (i < maxIterationCount) {
            double fValue = 0.0D;
            double fDerivative = 0.0D;
            for (int k = 0; k < values.length; k++) {
                fValue += values[k] / Math.pow(1.0D + x0, k);
                fDerivative += -k * values[k] / Math.pow(1.0D + x0, k + 1);
            }
            double x1 = x0 - fValue / fDerivative;
            if (Math.abs(x1 - x0) <= absoluteAccuracy) {
                return x1;
            }
            x0 = x1;
            i++;
        }
        return (0.0D / 0.0D);
    }
    public static double irr(double[] income) {
        return irr(income, 0.1D);
    }

    /**
     * 妈耶!这个算法有毒吧!
     * 还是没有搞懂啊!
     * 算了算了,放弃那个好用用哪个
     * @param args
     */
    public static void main(String[] args) {
        double[] arr = {-444, 150, 150, 150};
        double[] arr2 = {-444, 294, 294, 294};
        double[] arr3 = {-444, 408, 408, 408};
        double[] arr4 = {-444, 538, 538, 538};
        double ret = irr(arr4,0.00001d) ;
        double ret2 = irr(arr4) ;
        double ret3 = irr(arr4,0.666d) ;
        System.out.println(new BigDecimal(ret));
        System.out.println(new BigDecimal(ret2));
        System.out.println(new BigDecimal(ret3));

    }
}
