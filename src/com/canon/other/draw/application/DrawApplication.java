package com.canon.other.draw.application;

import com.canon.other.draw.algorithm.DrawLottery;
import com.canon.other.draw.model.Gift;

import java.util.List;

/**
 * @Auther: canon
 * @Date: 2018/11/5 09:37
 * @Description:
 */
public class DrawApplication {
    public static void main(String[] args) {
        List<Gift> gifts = DrawLottery.initParam();

        int phone = 0;
        int money = 0;
        int thanks = 0;

        for (int i = 0; i < 10000; i++) {
            int index = DrawLottery.drawAlgorithm(gifts);
            Gift gift = gifts.get(index);
            if (1001 == gift.getId()) {
                phone ++;
            } else if (1002 == gift.getId()) {
                money ++;
            } else {
                thanks ++;
            }

            System.out.println(gift);
        }
        System.out.println("抽到手机:" + phone + "次;" + "抽到代金券:" +
                money + "次;" + "抽到谢谢惠顾:" + thanks + "次");

    }
}
