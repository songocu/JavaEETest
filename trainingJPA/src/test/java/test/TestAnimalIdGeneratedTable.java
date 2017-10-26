package test;

import org.junit.Test;
import testIDS.Animal;
import testIDS.AnimalGenerateAutoID;

public class TestAnimalIdGeneratedTable extends TransactionalSetup{
	
	@Test
	public void testIdGeneratedTable(){
		Animal animal1=new Animal();
		animal1.setAge(23);
		animal1.setFoodType("Carnivor");
		
		Animal animal2=new Animal();
		animal2.setAge(23);
		animal2.setFoodType("Carnivor");
		
		Animal animal3=new Animal();
		animal3.setAge(23);
		animal3.setFoodType("Carnivor");
		
		em.persist(animal1);
		em.persist(animal2);
		em.persist(animal3);
		em.flush();
		
		
		AnimalGenerateAutoID generatedAutoID=new AnimalGenerateAutoID();
		generatedAutoID.setAge(24);
		generatedAutoID.setFoodType("Omnivor");
		AnimalGenerateAutoID generatedAutoID2=new AnimalGenerateAutoID();
		generatedAutoID2.setAge(24);
		generatedAutoID2.setFoodType("Omnivor");
		AnimalGenerateAutoID generatedAutoID3=new AnimalGenerateAutoID();
		generatedAutoID3.setAge(24);
		generatedAutoID3.setFoodType("Omnivor");
		
		em.persist(generatedAutoID);
		em.persist(generatedAutoID2);
		em.persist(generatedAutoID3);
		em.flush();
	}
}
