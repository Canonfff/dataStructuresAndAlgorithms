package com.canon.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/10/30 11:01
 * @Description:
 */
public class IRRUtil {
    private double MINDIF = 0.001;

    private int LOOPNUM = 2000;

    private static int period = 0;

    private List netCash = new ArrayList();


    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(-444);
        list.add(538);
        list.add(538);
        list.add(538);

        IRRUtil  aa = new IRRUtil(list,12);
        System.out.println(aa.calculator());

    }

    public IRRUtil(List netCashArr, int interval) {
        super();
        netCash = netCashArr;
        period = 12/interval;
    }

    private double NPV(double r) {

        double npv = 0;
        // mark Math.pow(x, y) --> 计算x的y次方
        if (netCash.size() != 0) {
            for (int count = 0; count < netCash.size(); count++) {
                npv += Double.valueOf(netCash.get(count).toString()) / Math.pow(1 + r, count);
            }
            return npv;
        }
        return Double.NaN;
    }

    public double calculator() {

        double irr = 0;
        double r1 = new BigDecimal("0.1").doubleValue();
        double r2 = new BigDecimal("0.09").doubleValue();
        double npv1 = NPV(r1);
        double npv2 = NPV(r2);
        //System.out.println(netCash+"--");
        int count = 0;
        while (Math.abs(npv2) > MINDIF & count < LOOPNUM) {
            irr = r2 - npv2 * (r2 - r1) / (npv2 - npv1);
            r1 = r2;
            r2 = irr;
            npv1 = npv2;
            npv2 = NPV(r2);
            count++;
            // System.out.println(count+"--");
        }
        // System.out.println(irr*period+"--");
        if (Math.abs(npv2) < MINDIF & count <= LOOPNUM) {

            //return irr * period ;
            return irr;
        } else {
            return Double.NaN;
        }
    }
}
