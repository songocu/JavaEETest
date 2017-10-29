package test;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.junit.Test;

import criteriaapi.CriteriaAPIEmployee;
import criteriaapi.CriteriaAPIEmployee_;
import test.TransactionalSetup;

public class TestCriteriaAPIMetamodel extends TransactionalSetup{
	@Test
	public void test() {

		CriteriaAPIEmployee employee = new CriteriaAPIEmployee();
		employee.setEname("Manisha");
		employee.setSalary(500D);
		employee.setDeg("Sef");

		CriteriaAPIEmployee employee1 = new CriteriaAPIEmployee();
		employee1.setEname("Satish");
		employee1.setSalary(501D);
		employee1.setDeg("Sef");

		CriteriaAPIEmployee employee2 = new CriteriaAPIEmployee();
		employee2.setEname("Gopal");
		employee2.setSalary(505D);
		employee2.setDeg("Angajat");

		em.persist(employee);
		em.persist(employee1);
		em.persist(employee2);

		em.flush();
		em.clear();

		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		//create the Query
		CriteriaQuery<CriteriaAPIEmployee> criteriaQuery = criteriaBuilder.createQuery(CriteriaAPIEmployee.class);
		//set the root class
		Root<CriteriaAPIEmployee> root = criteriaQuery.from(CriteriaAPIEmployee.class);
		//criteriaQuery.select(root);

		// select all records
		System.out.println("use metadata class to define the where class. Select all employees with name starting with M");
		criteriaQuery.where(criteriaBuilder.like(root.get(CriteriaAPIEmployee_.ename), "M%"));
		
		//perform query
		List<CriteriaAPIEmployee> resultlist = em.createQuery(criteriaQuery).getResultList();
		
		for (CriteriaAPIEmployee o : resultlist) {
			CriteriaAPIEmployee e = (CriteriaAPIEmployee) o;
			System.out.println("EID : " + e.getEid() + " Ename : " + e.getEname());
		}
		
	}
}
