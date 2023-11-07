package com.designpattern.creational.builder.ex2;

public class CheeseBurgerBuilder extends BurgerBuilder {
    @Override
    protected Burger build() {
        Burger burger = new Burger("Wheat Bread");
        burger.setCheese("Amul Cheese");
        burger.setSauce("secret sauce");
        return burger;
    }
}
