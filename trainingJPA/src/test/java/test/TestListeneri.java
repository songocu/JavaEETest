package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import testListeneri.Person;

public class TestListeneri extends TransactionalSetup {
	
	@Test
	public void testThatListenerWasActivatedAtCreation(){
		
		Person person=new Person();
		person.setName("Vasile");
		em.persist(person);
		em.flush();
		
		// TEST CREATE => READ
		em.clear();
		Person personToBeTested = em.find(Person.class, person.getId());
		assertTrue("Persons are not the same", personToBeTested.getCurrentAssign().equalsIgnoreCase("pre persist"));
		
	}

}
