package test;

import org.junit.Test;
import org.unitils.reflectionassert.ReflectionAssert;

import onetoonerelationship.Employee;
import onetoonerelationship.EmployeeAddressOneToOne;

public class TestOneToOneRelation extends TransactionalSetup {
	
	@Test
	public void testOneToOneRelation(){
		EmployeeAddressOneToOne employeeAddressOneToOne1=new EmployeeAddressOneToOne();
		employeeAddressOneToOne1.setCity("Iasi");
		employeeAddressOneToOne1.setStreet("Novac");
		employeeAddressOneToOne1.setZipCode(100);
		
		EmployeeAddressOneToOne employeeAddressOneToOne2=new EmployeeAddressOneToOne();
		employeeAddressOneToOne2.setCity("Buc");
		employeeAddressOneToOne2.setStreet("Ipsilanti");
		employeeAddressOneToOne2.setZipCode(200);
		
		Employee employee1=new Employee();
		employee1.setAddress(employeeAddressOneToOne1);
		employee1.setLastName("Sarah");
		employee1.setName("Smith");
		employee1.setSalary(50000);
		
		Employee employee2=new Employee();
		employee2.setAddress(employeeAddressOneToOne2);
		employee2.setLastName("Bob");
		employee2.setName("Way");
		employee2.setSalary(50000);
		
		em.persist(employeeAddressOneToOne2);
		em.persist(employeeAddressOneToOne1);
		em.persist(employee2);
		em.persist(employee1);
		em.flush();
		
		// TEST CREATE => READ
		em.clear();
//		SimpleEntity existingEntity1 = em.find(SimpleEntity.class, createdEntity.getId());
//		ReflectionAssert.assertLenientEquals(createdEntity, existingEntity1);
		Employee employeeFromDatabase1=em.find(Employee.class, employee1.getId());
		ReflectionAssert.assertLenientEquals(employeeFromDatabase1.getAddress(), employeeAddressOneToOne1);
		
				
	}

}
