package test;

import org.junit.Test;
import org.unitils.reflectionassert.ReflectionAssert;

import onetoonerelationshipbidirectional.EmployeeAddressOneToOneBidirectional;
import onetoonerelationshipbidirectional.EmployeeBidirectional;

public class TestOneToOneRelationBidirectional extends TransactionalSetup {
	
	@Test
	public void testOneToOneRelation(){
		EmployeeAddressOneToOneBidirectional EmployeeBidirectionalAddressOneToOneBidirectional1=new EmployeeAddressOneToOneBidirectional();
		EmployeeBidirectionalAddressOneToOneBidirectional1.setCity("Iasi");
		EmployeeBidirectionalAddressOneToOneBidirectional1.setStreet("Novac");
		EmployeeBidirectionalAddressOneToOneBidirectional1.setZipCode(100);
		
		EmployeeAddressOneToOneBidirectional EmployeeBidirectionalAddressOneToOneBidirectional2=new EmployeeAddressOneToOneBidirectional();
		EmployeeBidirectionalAddressOneToOneBidirectional2.setCity("Buc");
		EmployeeBidirectionalAddressOneToOneBidirectional2.setStreet("Ipsilanti");
		EmployeeBidirectionalAddressOneToOneBidirectional2.setZipCode(200);
		
		
		EmployeeBidirectional EmployeeBidirectional1=new EmployeeBidirectional();
		EmployeeBidirectional1.setAddress(EmployeeBidirectionalAddressOneToOneBidirectional1);
		EmployeeBidirectional1.setLastName("Sarah");
		EmployeeBidirectional1.setName("Smith");
		EmployeeBidirectional1.setSalary(50000);
		
		EmployeeBidirectional EmployeeBidirectional2=new EmployeeBidirectional();
		EmployeeBidirectional2.setAddress(EmployeeBidirectionalAddressOneToOneBidirectional2);
		EmployeeBidirectional2.setLastName("Bob");
		EmployeeBidirectional2.setName("Way");
		EmployeeBidirectional2.setSalary(50000);
		
		EmployeeBidirectionalAddressOneToOneBidirectional1.setEmployeeBidirectional(EmployeeBidirectional1);
		EmployeeBidirectionalAddressOneToOneBidirectional2.setEmployeeBidirectional(EmployeeBidirectional2);
		
		em.persist(EmployeeBidirectionalAddressOneToOneBidirectional2);
		em.persist(EmployeeBidirectionalAddressOneToOneBidirectional1);
		em.persist(EmployeeBidirectional2);
		em.persist(EmployeeBidirectional1);
		em.flush();
		
		// TEST CREATE => READ
		em.clear();
//		SimpleEntity existingEntity1 = em.find(SimpleEntity.class, createdEntity.getId());
//		ReflectionAssert.assertLenientEquals(createdEntity, existingEntity1);
		EmployeeBidirectional EmployeeBidirectionalFromDatabase1=em.find(EmployeeBidirectional.class, EmployeeBidirectional1.getId());
		ReflectionAssert.assertLenientEquals(EmployeeBidirectionalFromDatabase1.getAddress(), EmployeeBidirectionalAddressOneToOneBidirectional1);
		
				
	}

}
