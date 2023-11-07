package com.designpattern.creational.builder.ex2;

public class BurgerDirector {
    private BurgerBuilder burgerBuilder;
    public BurgerDirector(BurgerBuilder burgerBuilder) {
        this.burgerBuilder = burgerBuilder;
    }

    public Burger getBurger() {
        return this.burgerBuilder.build();
    }
}
