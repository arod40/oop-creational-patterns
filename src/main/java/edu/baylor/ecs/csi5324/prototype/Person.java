package edu.baylor.ecs.csi5324.prototype;

public class Person {
	String firstName;
	String lastName;
	int age;
	Company company;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Person(String firstName, String lastName, int age, Company company) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.company = company;
	}

	public Person(Person other){
		super();
		this.firstName = other.firstName;
		this.lastName = other.lastName;
		this.age = other.age;
		// I copy the reference, to avoid cycles.
		this.company = other.company;
	}
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", works for company=" + company.getName()
				+ "]";
	}

	public Person clone() {
		return new Person(this);
	}

	public boolean checkClone(Person other) {
		return other != this
			   && other.firstName == firstName
			   && other.lastName == lastName
			   && other.age == age
			   // Here I only check the reference matches, to avoid cycles.
			   && other.company == company;
	}
}
