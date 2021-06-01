package com.skilldisillery.jets.entity;

public class CargoPlane extends Jet implements CargoCarrier{
	
	private static int cargoPlaneIdNumGenerator = 10001;
	private int cargoPlaneIdNum; 
	{
		cargoPlaneIdNum = cargoPlaneIdNumGenerator;
		CargoPlane.cargoPlaneIdNumGenerator++;
	}
	
	public CargoPlane() { super("Unkown", 0, 0, 0.0); }
	public CargoPlane(String model, int speed, int range, double price) {
		super(model, speed, range, price);
	}
	
	@Override
	public void executeLoadProcedures() {
		System.out.println();
		fuelCarriers();
		loadCarriers();
		preFlightInspections();
		System.out.println("Cargo Plane #" + cargoPlaneIdNum + " Ready for Transport");
	}
	
	@Override
	public void fuelCarriers() {
		System.out.println("Fueling Cargo Plane #" + cargoPlaneIdNum);
	}

	@Override
	public void loadCarriers() {
		System.out.println("Loading Cargo Plane #" + cargoPlaneIdNum);
		System.out.println("Cargo Plane #" + cargoPlaneIdNum +
				           " loading complete");
	}
	
	@Override
	public void preFlightInspections() {
		System.out.println("Completing Pre-Flight inspections for " + 
						   "Caro Plane #" + cargoPlaneIdNum);
		System.out.println("Pre-flight inspections for Cargo Plane " +
						   "#" + cargoPlaneIdNum + " complete.");
		System.out.println("Cargo Plane #" + cargoPlaneIdNum + 
				           " passed");
	}

	@Override
	public void fly() {
		System.out.println("BUURRRMM the cargo jet bumbles through the air!");
		
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
