package com.canon.design.builder;

import com.canon.design.builder.demo.Calzone;
import com.canon.design.builder.demo.NyPizza;
import com.canon.design.builder.demo.Pizza;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Set;

/**
 * @PackageName: com.canon.design.builder
 * @Description:
 * @author: canon
 * @date: 2020/9/4 9:56
 * @Version: 1.0
 */
public class Application {
    public static void main(String[] args) {
//        Pizza nyPizza = new NyPizza.Builder(NyPizza.Size.SMALL).addToppings(Pizza.Topping.SAUSAGE).addToppings(Pizza.Topping.ONION).build();
//        Pizza calzone = new Calzone.Builder().addToppings(Pizza.Topping.HAM).sauceInside().build();
        EnumSet<Pizza.Topping> toppings = EnumSet.noneOf(Pizza.Topping.class);
        EnumSet<Pizza.Topping> toppings2 = EnumSet.allOf(Pizza.Topping.class);

        System.out.println(toppings);
        System.out.println(toppings2);

        EnumMap<Pizza.Topping, Set<Pizza>> map = new EnumMap<>(Pizza.Topping.class);
    }
}
