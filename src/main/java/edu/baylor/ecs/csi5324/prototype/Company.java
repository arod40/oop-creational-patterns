package edu.baylor.ecs.csi5324.prototype;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
		this.members = other.members.stream().map(person -> person.clone()).collect(
				 Collectors.toSet());
		this.cars = other.cars.stream().map(car -> car.clone()).collect(
				Collectors.toSet());
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

	public boolean checkClone(Company other) {
		if (other.name != name) return false;

		List<Car> otherCars = other.cars.stream().sorted(
				Comparator.comparing(Car::getName)).collect(Collectors.toList());
		List<Car> myCars = cars.stream().sorted(
				Comparator.comparing(Car::getName)).collect(Collectors.toList());
		if (otherCars.size() != myCars.size()) return false;
		for (int i = 0; i< myCars.size(); i++){
			Car myCar = myCars.get(i);
			Car otherCar = otherCars.get(i);
			if (myCar == otherCar || !myCar.checkClone(otherCar)) return false;
		}

		List<Person> otherMembers = other.members.stream().sorted(
				Comparator.comparing(Person::getFirstName)
						.thenComparing(Person::getLastName)
						.thenComparing(Person::getAge)).collect(Collectors.toList());
		List<Person> myMembers = members.stream().sorted(
				Comparator.comparing(Person::getFirstName)).collect(
				Collectors.toList());
		if (otherMembers.size() != myMembers.size()) return false;
		for (int i = 0; i< myMembers.size(); i++){
			Person myMember = myMembers.get(i);
			Person otherMember = otherMembers.get((i));
			if (myMember == otherMember || !myMember.checkClone(otherMember)) return false;
		}
		return true;
	}
}
