package com.skilldisillery.jets.entity;

import java.util.List;
import java.util.ArrayList;

public class AirField {
	private List<Jet> jets;
	private static Jet fastestJet;
	private static Jet longestRangeJet;
	
	public AirField() {
		this.jets = new ArrayList<>();
	}

	public List<Jet> getJets() {
		return jets;
	}
	public void addJet(Jet jet) {
		this.jets.add(jet);
	}
	
	public void displayFleet() {
		System.out.println();
		for (Jet jet : jets) {
			System.out.println(jet.toString());
		}
	}
	
	public void flyAllJets() {
		System.out.println();
		for (Jet jet : jets) {
			jet.fly();
		}
	}
	
	public int getNumberOfJets() {
		int num = 0;
		for (Jet jet : jets) {
			if(!jet.equals(null)) {
				num++;
			}
		}
		return num;
	}
	
	public void printFastestJet() {
		System.out.println();
		System.out.println(getFastestJet().toString());
	}
	
	public Jet getFastestJet() {
		return AirField.fastestJet;
	}

	public void searchAndSetFastestJet() {
		int speed = 0;
		for (Jet jet : jets) {
			if(jet.getSpeed() > speed) {
				speed = jet.getSpeed();
				AirField.fastestJet = jet;
			}
		}
	}
	
	public void printLongestRangeJet() {
		System.out.println();
		System.out.println(getLongestRangeJet().toString());
	}	
	
	public Jet getLongestRangeJet() {
		return AirField.longestRangeJet;
	}
	
	public void searchAndSetLongestRangeJet() {
		int range = 0;
		for (Jet jet : jets) {
			if(jet.getRange() > range) {
				range = jet.getRange();
				AirField.longestRangeJet = jet;
			}
		}
	}
}
