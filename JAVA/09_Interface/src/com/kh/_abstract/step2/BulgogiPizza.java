package com.kh._abstract.step2;

public class BulgogiPizza extends Pizza{

	public BulgogiPizza(int price, String brand) {
		super(price, brand);
	}

	@Override
	public void topping() {
		System.out.println("Bulgogi Topping ...");
	}
	
}
