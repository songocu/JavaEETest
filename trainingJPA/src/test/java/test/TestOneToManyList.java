package test;

import org.junit.Test;

import onetomanylist.PrintJob;
import onetomanylist.PrintQueue;

public class TestOneToManyList extends TransactionalSetup {

	@Test
	public void test() {
		PrintQueue q = new PrintQueue();
		q.setName("q1");

		PrintJob j = new PrintJob();
		j.setId(5);
		j.setQueue(q);
		
		PrintJob j1 = new PrintJob();
		j1.setId(6);
		j1.setQueue(q);
		
		PrintJob j2 = new PrintJob();
		j2.setId(4);
		j2.setQueue(q);

		q.getJobs().add(j);
		q.getJobs().add(j1);
		q.getJobs().add(j2);
		em.persist(j);
		em.persist(j1);
		em.persist(j2);
		em.persist(q);
		em.flush();
	}

}
