package edu.baylor.ecs.csi5324.prototype;

import java.util.HashSet;
import java.util.Set;

public class Company {
	String name;
	Set<Person> members = new HashSet<Person>();
	Set<Car> cars = new HashSet<Car>();

	public Company(String name) {
		super();
		this.name = name;
	}

	/**
	 * This is a copy constructor!
	 * @param other
	 */
	public Company(Company other) {
		super(); // super(this) is there is a polymorphism
		this.name = other.name;
		// todo:
		// this.members = ??
		// this.cars = ??
	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Person> getMembers() {
		return members;
	}

	public void setMembers(Set<Person> members) {
		this.members = members;
	}

	public Set<Car> getCars() {
		return cars;
	}

	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}

	@Override
	public String toString() {
		String out = "Company [name=" + name + ", members=" + members.size() + ", cars=" + cars.size() + "]";
		out += "\nPersons:\n";
		for (Person p : members) {
			out += "* "+p.toString()+"\n";
		}
		out += "\nCars:\n";
		for (Car c : cars) {
			out +="* "+c.toString()+"\n";
		}
		return out;
	}
	
	public Company clone() {
		return new Company(this);
	}

}
