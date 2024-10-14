package com.designpattern.structural.decorator;

public class PizzaShop {

	public static void main(String[] args) {
		BasePizza pizza = //code to parent
			new ExtraMushroomDecorator( // topping-2 returns base pizza
				new ExtraCheeseDecorator( // topping-1 returns base pizza
					new FarmhousePizza() // base pizza
				)
			);

		int cost = pizza.cost();
		System.out.println("The cost of pizza :" + cost);

		BasePizza anotherPizza = //code to parent
			new ExtraMushroomDecorator( // topping-2 returns base pizza
				new ExtraCheeseDecorator( // topping-1 returns base pizza
					new MargheritaPizza() // base pizza
				)
			);

		int cost2 = anotherPizza.cost();
		System.out.println("The cost of pizza :" + cost2);
	}
}
