package test;

import org.junit.Test;

import onetomany.Department;
import onetomany.PersonOneToMany;

public class TestOneToMany extends TransactionalSetup {
	@Test
	public void test() {
		Department d = new Department();
		d.setName("Design");

		PersonOneToMany p1 = new PersonOneToMany("Tom");
		p1.setDepartment(d);

		PersonOneToMany p2 = new PersonOneToMany("Jack");
		p2.setDepartment(d);

		em.persist(p1);
		em.persist(p2);
		em.persist(d);
		em.flush();

	}
}