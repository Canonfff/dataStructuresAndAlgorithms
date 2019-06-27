package com.canon.other.draw.model;

import java.math.BigDecimal;

/**
 * @Auther: canon
 * @Date: 2018/11/5 09:18
 * @Description:
 */
public class Gift {

    private Long id;
    private String giftName;
    // private Double prob;
    private BigDecimal prob;

    public Gift() {
    }

    public Gift(Long id, String giftName, BigDecimal prob) {
        this.id = id;
        this.giftName = giftName;
        this.prob = prob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

    public BigDecimal getProb() {
        return prob;
    }

    public void setProb(BigDecimal prob) {
        this.prob = prob;
    }

    @Override
    public String toString() {
        return "Gift{" +
                "id=" + id +
                ", giftName='" + giftName + '\'' +
                ", prob=" + prob +
                '}';
    }
}
