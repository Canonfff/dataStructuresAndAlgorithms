package com.canon.design.builder.demo;

/**
 * @PackageName: com.canon.design.builder.demo
 * @Description:
 * @author: canon
 * @date: 2020/9/4 9:51
 * @Version: 1.0
 */
public class Calzone extends Pizza {
    private final boolean sauceInside;

    public static class Builder extends Pizza.Builder<Builder> {

        private boolean sauceInside = false;// default

        public Builder sauceInside() {
            sauceInside = true;
            return this;
        }

        @Override
        public Pizza build() {
            return new Calzone(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    public Calzone(Builder builder) {
        super(builder);
        sauceInside = builder.sauceInside;
    }
}
