package com.skilldisillery.jets.entity;

public class CargoPlane extends Jet {

	public CargoPlane() { super("Unkown", 0, 0, 0.0); }
	public CargoPlane(String model, int speed, int range, double price) {
		super(model, speed, range, price);
	}

	@Override
	public void fly() {
		System.out.println("BUURRRMM the cargo jet bumbles through the air!");
		
	}

	@Override
	public double getSpeedInMach() {
		return super.getSpeed() / 767.269;
	}

}
