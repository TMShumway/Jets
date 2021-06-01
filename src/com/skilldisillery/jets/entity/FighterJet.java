package com.skilldisillery.jets.entity;

public class FighterJet extends Jet implements CombatJet {
	
	private static int fighterJetIdNumGenerator = 10001;
	private int fighterJetIdNum; 
	{
		fighterJetIdNum = fighterJetIdNumGenerator;
		FighterJet.fighterJetIdNumGenerator++;
	}

	public FighterJet() { super("Unkown", 0, 0, 0.0); }
	public FighterJet(String model, int speed, int range, double price) {
		super(model, speed, range, price);
	}

	@Override
	public void fly() {
		System.out.println("Pew Pew this fighterjet is screaming!");
		
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
	
	@Override
	public void executeDogFight() {
		System.out.println();
		preFlightChecks();
		loadAmmunition();
		targetEnemy();
		attackEnemy();
		System.out.println("Target Destoryed." + " Fighter Jet #" + 
		                   fighterJetIdNum + " returning to Airfield.");
		
	}
	
	@Override
	public void loadAmmunition() {
		System.out.println("Fighter Jet #" + fighterJetIdNum + " ammunition loaded.");
		
	}
	@Override
	public void preFlightChecks() {
		System.out.println("Fighter Jet #" + fighterJetIdNum + 
				           " ready for combat.");	
	}
	@Override
	public void targetEnemy() {
		System.out.println("Fighter Jet #" + fighterJetIdNum + 
				" targeting enemy aircraft.");			
	}
	@Override
	public void attackEnemy() {
		System.out.println("Fighter Jet #" + fighterJetIdNum + 
				" firing missile.");					
	}

	
	
}
