package edu.baylor.ecs.csi5324.prototype;

public class Cleaner extends Person {
	private String specialization;

	public Cleaner(String firstName, String lastName, int age, Company company, String specialization) {
		super(firstName, lastName, age, company);
		this.specialization = specialization;
	}

	public Cleaner(Cleaner other){
		super(other);
		this.specialization = other.specialization;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	@Override
	public String toString() {
		return "Cleaner [specialization=" + specialization + ", toString()=" + super.toString() + "]";
	}

	public Person clone() {
		return new Cleaner(this);
	}

	public boolean checkClone(Person other) {
		if (!super.checkClone(other)) return false;
		Cleaner otherCleaner;
		try{
			otherCleaner = (Cleaner) other;
		}
		catch (Exception e){
			return false;
		}
		return otherCleaner.specialization == specialization;

	}
}
