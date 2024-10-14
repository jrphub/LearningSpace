package com.designpattern.structural.decorator;

public class ExtraCheeseDecorator extends ToppingDecorator {

	//Has-A
	BasePizza basePizza;

	ExtraCheeseDecorator(BasePizza pizza) {
		this.basePizza = pizza;
	}

	@Override
	int cost() {
		return this.basePizza.cost() + 10;
	}
}
