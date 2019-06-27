package com.canon.base.class_one;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Auther: canon
 * @Date: 2018/10/22 10:04
 * @Description:
 */
public class TestSix {
    public static void main(String[] args) {
//        Date startDate = new Date("2018-10-21 00:00:00");
        Date startDate = new Date(2018-1900,10,1);
        Date endDate = new Date(2018-1900,10,30);
        Date signDate = new Date(2018-1900,9,20);
        String payMonthType = "02";
        Date date = getMustReceiptDate(startDate, 30, payMonthType, endDate, signDate);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        // System.out.println(format.format(date));
        System.out.println(fn());

    }

    static Date getMustReceiptDate(Date startDate, int day, String payMonthType,
                                   Date endDate, Date signDate) {
        int peroid = 2;


        if (peroid == 1) {
            return signDate;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        if ("02".equals(payMonthType)) {
            calendar.add(Calendar.MONTH, -1);
        }
        int maxDay = calendar.getActualMaximum(Calendar.DATE);
        if (day > maxDay) {
            day = maxDay;
        }
        calendar.set(Calendar.DATE, day);
        //比较账单日和合同结束日期，结束日先到就以结束日为账单日
        if(calendar.getTime().compareTo(endDate)>=0){
            return endDate;
        }
        return calendar.getTime();
    }
    static boolean fn() {
        Date date = new Date(2018-1900,9,20);
        Date startDate = new Date(2018-1900,9,21);
        return date.compareTo(startDate) < 0;
    }

}
