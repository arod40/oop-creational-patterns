package edu.baylor.ecs.csi5324.prototype;

public class Worker extends Person {
	int salary;

	public Worker(String firstName, String lastName, int age, Company company, int salary) {
		super(firstName, lastName, age, company);
		this.salary = salary;
	}

	public Worker(Worker other){
		super(other);
		this.salary = other.salary;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Worker [salary=" + salary + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", company=" + company.getName() + "]";
	}

	public Person clone() {
		return new Worker(this);
	}

	public boolean checkClone(Person other) {
		if (!super.checkClone(other)) return false;
		Worker otherCleaner;
		try{
			otherCleaner = (Worker) other;
		}
		catch (Exception e){
			return false;
		}
		return otherCleaner.salary == salary;
	}
}
