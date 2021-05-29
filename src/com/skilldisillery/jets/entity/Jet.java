package com.skilldisillery.jets.entity;

public abstract class Jet {
	
	private String model;
	private int speed;
	private int range;
	private double price;
	
	public Jet(String model, int speed, int range, double price) {
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

	public abstract void fly();
	
	public abstract double getSpeedInMach();

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + range;
		result = prime * result + speed;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jet other = (Jet) obj;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (range != other.range)
			return false;
		if (speed != other.speed)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("%-10s", this.getClass().getSimpleName()));
		builder.append(": model = ");
		builder.append(model);
		builder.append(", speed = ");
		builder.append(String.format("%-4d", speed));
		builder.append(" mph, range = ");
		builder.append(range);
		builder.append(" miles, price = $");
		builder.append(price);
		return builder.toString();
	}
	
	
}
