package com.skilldisillery.jets.entity;

public class JetImpl extends Jet {

	private static int jetImplIdNumGenerator = 10001;
	private int jetImplIdNum; 
	{
		jetImplIdNum = jetImplIdNumGenerator;
		JetImpl.jetImplIdNumGenerator++;
	}
	
	public JetImpl() { super("Unkown", 0, 0, 0.0); }
	public JetImpl(String model, int speed, int range, double price) {
		super(model, speed, range, price);
	}

	@Override
	public void fly() {
		System.out.println("Shwooooo the jetimpl is cruising! ");
		
		double flightTimeRemaining = super.getRange() / (double)super.getSpeed();
		System.out.println("Range: " + super.getRange() + " and " +
		                   "Current Speed: " + super.getSpeed());
		
		System.out.println(flightTimeRemaining + " hours of flight time remaining.");
		System.out.println();
	}

	@Override
	public double getSpeedInMach() {
	
		return super.getSpeed() / 767.269;
	
	}

	
}
