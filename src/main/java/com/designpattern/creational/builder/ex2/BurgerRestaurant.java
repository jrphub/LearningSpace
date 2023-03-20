package com.designpattern.creational.builder.ex2;

public class BurgerRestaurant {
    public static void main(String[] args) {
        CheeseBurgerBuilder builder1 = new CheeseBurgerBuilder();
        BurgerDirector director1 = new BurgerDirector(builder1);
        Burger burger1 = director1.getBurger();
        System.out.println(burger1);

        MeatBurgerBuilder builder2 =  new MeatBurgerBuilder();
        BurgerDirector director2 = new BurgerDirector(builder2);
        Burger burger2 = director2.getBurger();
        System.out.println(burger2);
    }
}
