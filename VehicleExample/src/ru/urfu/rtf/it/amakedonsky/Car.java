package ru.urfu.rtf.it.amakedonsky;

public class Car extends Vehicle {
	
	private Float enginesVolume;
	private Integer price;

	public Car() {
		super();
		this.enginesVolume = new Float(1.5);
		this.price = 1000;
	}

	public Car(Integer count, String color, Float enginesVolume, 
			Integer price) {
		super(count, color);
		this.enginesVolume = enginesVolume;
		this.price = price;
	}

	public Float getEnginesVolume() {
		return enginesVolume;
	}

	public void setEnginesVolume(Float enginesVolume) {
		this.enginesVolume = enginesVolume;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	
	public static void getSound() {
		System.out.println("Beep - beep!");
	}
}
