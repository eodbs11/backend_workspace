package com.kh._abstract.step2;



public class PineApplePizza extends Pizza{	

	public PineApplePizza(int price, String brand) {
		super(price, brand);
	}

	@Override
	public void topping() {
		System.out.println("PineApple Topping ... ");
	}

}
