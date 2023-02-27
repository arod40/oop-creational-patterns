package edu.baylor.ecs.csi5324.prototype;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;


public class UserTest {

	private Company company;

	@BeforeEach
	public void setUp() {
		company = new Company("DreamVille");
		Car car1 = new Car("BMW");
		Car car2 = new Car("Mercedes");
		company.getCars().add(car1);
		company.getCars().add(car2);
		Executive boss1 = new Executive("Bob", "Smith", 55, company, "Super Executive");
		Executive boss2 = new Executive("Bob", "Smith Jr", 25, company, "Minor Executive");
		Person worker1 = new Worker("Pete", "Harworker", 25, company, 1000);
		Person worker2 = new Worker("Ron", "Lazyworker", 35, company, 1000);
		Person cleaner = new Cleaner("Ford", "Cleaner", 45, company, "Floor");
		boss1.setSharesCar(car1);
		boss2.setSharesCar(car1);
		
		boss1.getCommands().add(boss2);
		boss1.getCommands().add(worker1);
		
		boss2.getCommands().add(worker2);
		boss2.getCommands().add(cleaner);
		
		company.getMembers().add(boss2);
		company.getMembers().add(boss1);
		company.getMembers().add(worker1);
		company.getMembers().add(worker2);
		company.getMembers().add(cleaner);
	}

	@Test
	public void test() throws Exception {
		Company clonned = company.clone();
		
		//print
		System.out.println("***original");
		System.out.println(company);
		//print
		System.out.println("***clonned");
		System.out.println(clonned);

		assertTrue(company != clonned);
		assertTrue(company.checkClone(clonned));
	}
}
