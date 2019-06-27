package com.canon.other.draw.algorithm;

import com.canon.other.draw.model.Gift;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Auther: canon
 * @Date: 2018/11/5 09:21
 * @Description:
 */
public class DrawLottery {

    public static List<Gift> initParam() {
        List<Gift> gifts = new ArrayList<Gift>();
        Gift f1 = new Gift(1001L,"iphone X",BigDecimal.valueOf(0.001D));
        Gift f2 = new Gift(1002L,"十元代金券",BigDecimal.valueOf(0.01D));
        Gift f3 = new Gift(1003L,"谢谢惠顾",BigDecimal.valueOf(0.989D));

        gifts.add(f1);
        gifts.add(f2);
        gifts.add(f3);

        return gifts;
    }


    public static int drawAlgorithm(List<Gift> gifts) {
        if (gifts != null && gifts.size() > 0) {
            List<BigDecimal> probs = new ArrayList<BigDecimal>(gifts.size());
            for (Gift gift : gifts) {
                probs.add(gift.getProb());
            }
            return draw(probs);
        }
        return -1;
    }

    static int draw(List<BigDecimal> probs) {
        BigDecimal sumRate = BigDecimal.ZERO;
        for (BigDecimal prob : probs) {
            sumRate =  sumRate.add(prob);
        }

        if (sumRate.compareTo(BigDecimal.ZERO) != 0) {
            BigDecimal rate = BigDecimal.ZERO;
            List<BigDecimal> sortProbs = new ArrayList<BigDecimal>();
            for (BigDecimal prob : probs) {
                rate = rate.add(prob);
                sortProbs.add(rate.divide(sumRate));
            }

            BigDecimal random = BigDecimal.valueOf(Math.random());
            sortProbs.add(random);
            Collections.sort(sortProbs);

            return sortProbs.indexOf(random);
        }
        return -1;
    }

}
