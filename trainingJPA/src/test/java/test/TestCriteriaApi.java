package test;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.junit.Test;

import criteriaapi.CriteriaAPIEmployee;



public class TestCriteriaApi extends TransactionalSetup{
	@Test
	public void test() {

		CriteriaAPIEmployee employee=new CriteriaAPIEmployee();
		employee.setEname("Manisha");
		employee.setSalary(500D);
		employee.setDeg("Sef");
		
		CriteriaAPIEmployee employee1=new CriteriaAPIEmployee();
		employee1.setEname("Satish");
		employee1.setSalary(501D);
		employee1.setDeg("Sef");
		
		CriteriaAPIEmployee employee2=new CriteriaAPIEmployee();
		employee2.setEname("Gopal");
		employee2.setSalary(505D);
		employee2.setDeg("Angajat");
		
		em.persist(employee);
		em.persist(employee1);
		em.persist(employee2);
		
		em.flush();
		em.clear();
		
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
		Root<CriteriaAPIEmployee> from = criteriaQuery.from(CriteriaAPIEmployee.class);

		// select all records
		System.out.println("Select all records");
		CriteriaQuery<Object> select = criteriaQuery.select(from);
		TypedQuery<Object> typedQuery = em.createQuery(select);
		List<Object> resultlist = typedQuery.getResultList();

		for (Object o : resultlist) {
			CriteriaAPIEmployee e = (CriteriaAPIEmployee) o;
			System.out.println("EID : " + e.getEid() + " Ename : " + e.getEname());
		}

		// Ordering the records
		System.out.println("Select all records by follow ordering");
		CriteriaQuery<Object> select1 = criteriaQuery.select(from);
		select1.orderBy(criteriaBuilder.asc(from.get("ename")));
		TypedQuery<Object> typedQuery1 = em.createQuery(select);
		List<Object> resultlist1 = typedQuery1.getResultList();

		for (Object o : resultlist1) {
			CriteriaAPIEmployee e = (CriteriaAPIEmployee) o;
			System.out.println("EID : " + e.getEid() + " Ename : " + e.getEname());
		}
	}
}