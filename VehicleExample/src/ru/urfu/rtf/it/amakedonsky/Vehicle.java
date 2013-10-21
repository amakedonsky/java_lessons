package ru.urfu.rtf.it.amakedonsky;

public class Vehicle {

	private Integer wheelsCount;
	private String vehiclesColor;
	
	public Vehicle() {
		this.wheelsCount = 2;
		this.vehiclesColor = "red";
	}
	
	public Vehicle(Integer count, String color) {
		this.wheelsCount = count;
		this.vehiclesColor = color;
	}
	
	public Integer getWheelsCount() {
		return wheelsCount;
	}
	public void setWheelsCount(Integer newWheelsCount) {
		this.wheelsCount = newWheelsCount;
	}
	public String getVehiclesColor() {
		return vehiclesColor;
	}
	public void setVehiclesColor(String newVehiclesColor) {
		this.vehiclesColor = newVehiclesColor;
	}
}
