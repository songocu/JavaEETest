package test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public abstract class Setup {
	protected static EntityManagerFactory factory;
	
	@BeforeClass
	static public void beforeAllTests(){
		factory = Persistence.createEntityManagerFactory("examplePersistenceUnit");
	}
	
	
	@AfterClass
	static public void afterAllTest(){
		factory.close();
	}
}
