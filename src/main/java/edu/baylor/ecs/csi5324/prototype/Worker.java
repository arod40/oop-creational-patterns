package edu.baylor.ecs.csi5324.prototype;

public class Worker extends Person {
	int salary;

	public Worker(String firstName, String lastName, int age, Company company, int salary) {
		super(firstName, lastName, age, company);
		this.salary = salary;
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
}
