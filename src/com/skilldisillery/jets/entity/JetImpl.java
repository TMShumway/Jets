package com.skilldisillery.jets.entity;

public class JetImpl extends Jet {

	public JetImpl() { super("Unkown", 0, 0, 0.0); }
	public JetImpl(String model, int speed, int range, double price) {
		super(model, speed, range, price);
	}

	@Override
	public void fly() {
		System.out.println("Shwooooo the jet is cruising!");
	}

	@Override
	public double getSpeedInMach() {
	
		return super.getSpeed() / 767.269;
	
	}

	
}
