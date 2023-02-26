package edu.baylor.ecs.csi5324.prototype;

import java.util.HashSet;
import java.util.Set;

public class Executive extends Person {
	String position;
	Car sharesCar;
	Set<Person> commands = new HashSet<Person>();

	public String getPosition() {
		return position;
	}

	public Executive(String firstName, String lastName, int age, Company company, String position) {
		super(firstName, lastName, age, company);
		this.position = position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Car getSharesCar() {
		return sharesCar;
	}

	public void setSharesCar(Car sharesCar) {
		this.sharesCar = sharesCar;
	}

	public Set<Person> getCommands() {
		return commands;
	}

	public void setCommands(Set<Person> commands) {
		this.commands = commands;
	}

	@Override
	public String toString() {
		String out = "Executive [position=" + position + ", toString()=" + super.toString() + "]";
		out += "\nCar: "+sharesCar.getName();
		out += "\nCommands:\n";
		for (Person p : commands) {
			out +="# "+p.toString()+"\n";
		}
		return out;
	}
}
