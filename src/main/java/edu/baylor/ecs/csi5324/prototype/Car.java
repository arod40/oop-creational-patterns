package edu.baylor.ecs.csi5324.prototype;

public class Car {

	public Car(String name) {
		super();
		this.name = name;
	}

	public Car(Car other){
		super();
		this.name = other.name;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + "]";
	}

	public Car clone(){
		return new Car(this);
	}

	public boolean checkClone(Car other) {
		return other != this && name == other.name;
	}
}
