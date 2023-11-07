package com.designpattern.creational.builder.ex2;

public class VegBurgerBuilder extends BurgerBuilder{
    @Override
    protected Burger build() {
        Burger burger = new Burger("Brown bread");
        burger.setSauce("secret sauce");
        burger.setSalad("more salad");
        return null;
    }
}
