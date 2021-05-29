package com.skilldisillery.jets.entity;

public class FighterJet extends Jet {

	public FighterJet() { super("Unkown", 0, 0, 0.0); }
	public FighterJet(String model, int speed, int range, double price) {
		super(model, speed, range, price);
	}

	@Override
	public void fly() {
		System.out.println("Pew Pew this fighterjet is screaming!");
		
	}

	@Override
	public double getSpeedInMach() {
		
		return super.getSpeed() / 767.269;
	}

	
	
}
