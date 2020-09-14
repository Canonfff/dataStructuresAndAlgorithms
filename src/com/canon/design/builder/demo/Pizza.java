package com.canon.design.builder.demo;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * @PackageName: com.canon.design.builder.demo
 * @Description:
 * @author: canon
 * @date: 2020/9/4 9:28
 * @Version: 1.0
 */
public abstract class Pizza {
    public enum Topping{HAM, MUSHROOM,ONION,PEPPER,SAUSAGE}
    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addToppings(Topping topping){
            toppings.add(Objects.requireNonNull(topping, "toppings can not be null"));
            return self();
        }

        abstract Pizza build();

        protected abstract T self();
    }

    public Pizza(Builder builder) {
        toppings = builder.toppings.clone();
    }
}
