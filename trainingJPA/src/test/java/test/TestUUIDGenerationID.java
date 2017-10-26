package test;

import org.junit.Test;

import testIDS.TestIDSUsingUUID;

public class TestUUIDGenerationID extends TransactionalSetup{
	
	@Test
	public void testUUIDGenerated(){
		
		TestIDSUsingUUID test1 = new TestIDSUsingUUID();
		test1.setName("Gigi1");
		TestIDSUsingUUID test2 = new TestIDSUsingUUID();
		test2.setName("Gigi2");
		TestIDSUsingUUID test3 = new TestIDSUsingUUID();
		test3.setName("Gigi3");
		TestIDSUsingUUID test4 = new TestIDSUsingUUID();
		test4.setName("Gigi4");
		
		em.persist(test1);
		em.persist(test2);
		em.persist(test3);
		em.flush();
	}

}
