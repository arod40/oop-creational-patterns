package edu.baylor.ecs.csi5324.prototype;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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

	public Executive(Executive other) {
		super(other);
		this.position = other.position;
		this.sharesCar = other.sharesCar.clone();

		// I am not cloning this level to avoid cycles
		// (if a person commands itself, for example)
		this.commands = new HashSet<>(other.commands);
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

	public Person clone() {
		return new Executive(this);
	}

	public boolean checkClone(Person other) {
		if (!super.checkClone(other)) return false;
		Executive otherExecutive;
		try{
			otherExecutive = (Executive) other;
		}
		catch (Exception e){
			return false;
		}

		return otherExecutive.position == position
			   && otherExecutive.sharesCar.checkClone(sharesCar)
			   // By the same token as before, here I only check if the references match
			   // to avoid cycles.
			   && otherExecutive.commands.containsAll(commands)
			   && commands.containsAll(otherExecutive.commands);
	}
}
