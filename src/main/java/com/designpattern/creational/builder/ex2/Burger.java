package com.designpattern.creational.builder.ex2;

public class Burger {
    private String bun = "No Bun";
    private String cheese = "No cheese";

    private String meat = "No meat";

    private String sauce = "No Sauce";

    private String salad = "No Salad";

    public Burger(String bun) {
        this.bun = bun;
    }

    public String getCheese() {
        return cheese;
    }

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public String getMeat() {
        return meat;
    }

    public void setMeat(String meat) {
        this.meat = meat;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public String getSalad() {
        return salad;
    }

    public void setSalad(String salad) {
        this.salad = salad;
    }

    @Override
    public String toString() {
        return "Burger{" +
                "bun='" + bun + '\'' +
                ", cheese='" + cheese + '\'' +
                ", meat='" + meat + '\'' +
                ", sauce='" + sauce + '\'' +
                ", salad='" + salad + '\'' +
                '}';
    }
}
