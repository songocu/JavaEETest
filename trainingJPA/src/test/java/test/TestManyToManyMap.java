package test;

import org.junit.Test;

import manytomanymap.DepartmentManyToManyMap;
import manytomanymap.PersonManyToManyMap;

public class TestManyToManyMap extends TransactionalSetup {
	@Test
	public void test(){
	    DepartmentManyToManyMap d1 = new DepartmentManyToManyMap();
	    d1.setName("Design");

	    DepartmentManyToManyMap d2 = new DepartmentManyToManyMap();
	    d2.setName("Testing");
	    
	    PersonManyToManyMap p1 = new PersonManyToManyMap("Tom");
	    p1.getDepartments().add(d1);
	    p1.getDepartments().add(d2);
	    
	    PersonManyToManyMap p2 = new PersonManyToManyMap("Jack");
	    p2.getDepartments().add(d1);
	    p2.getDepartments().add(d2);
	    
	    d1.getPersons().add(p1);
	    d1.getPersons().add(p2);
	    
	    
	    em.persist(p1);
	    em.persist(p2);
	    em.persist(d1);
	    em.persist(d2);
	}
}
