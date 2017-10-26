package test;

import org.junit.Test;

import onetomanymap.DepartmentOneToManyMap;
import onetomanymap.PersonOneToManyMap;

public class TestOneToManyMap extends TransactionalSetup {
	
	@Test
	public void testOneToManyMap() {
	    DepartmentOneToManyMap d = new DepartmentOneToManyMap();
	    d.setName("Design");

	    PersonOneToManyMap p1 = new PersonOneToManyMap("Tom");
	    p1.setDepartment(d);

	    PersonOneToManyMap p2 = new PersonOneToManyMap("Jack");
	    p2.setDepartment(d);
	    
	    d.getPersons().add(p1);
	    d.getPersons().add(p2);
	    
	    em.persist(p1);
	    em.persist(p2);
	    em.persist(d);

	}

}
