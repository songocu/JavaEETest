package test;

import java.util.List;

import org.junit.Test;

import onetomanylist.PrintJob;
import onetomanylist.PrintQueue;

public class TestSimpleQueryPrintJob extends TransactionalSetup {
	@Test
	public void test(){
		
		prepareData();
		List<PrintJob> listPrintJob = em.createQuery("SELECT e FROM PrintJob e",PrintJob.class).getResultList();
		for (PrintJob printJob : listPrintJob) {
			System.out.println(printJob);
		}
	}
	
	private void prepareData(){
		
		PrintQueue printQueue = new PrintQueue();
		printQueue.setName("FirstQue");
		PrintJob printJob=new PrintJob();
		printJob.setQueue(printQueue);
		
		em.persist(printJob);
		
		em.flush();
	}
}