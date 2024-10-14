package com.designpattern.structural.decorator;

public class ExtraMushroomDecorator extends ToppingDecorator {
	BasePizza basePizza;

	ExtraMushroomDecorator(BasePizza basePizza) {
		this.basePizza = basePizza;
	}

	@Override
	int cost() {
		return basePizza.cost() + 15;
	}
}
