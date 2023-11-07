package com.designpattern.creational.builder.ex2;

public class MeatBurgerBuilder extends BurgerBuilder{
    @Override
    protected Burger build() {
        Burger burger = new Burger("Brown Bread");
        burger.setSauce("secret sauce");
        burger.setMeat("Chicken");
        burger.setSalad("less salad");
        return burger;
    }
}
