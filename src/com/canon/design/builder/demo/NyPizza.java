package com.canon.design.builder.demo;

import java.util.Objects;

/**
 * @PackageName: com.canon.design.builder.demo
 * @Description:
 * @author: canon
 * @date: 2020/9/4 9:36
 * @Version: 1.0
 */
public class NyPizza extends Pizza {

    public enum Size{SMALL, MEDIUM, LARGE}

    private final Size size;

    public static class Builder extends Pizza.Builder<Builder> {

        private final Size size;

        public Builder(Size size){
            this.size = Objects.requireNonNull(size);
        }

        @Override
        public Pizza build() {
            return new NyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    public NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }
}
