package test;
import java.util.List;

import javax.persistence.TypedQuery;

import org.junit.Test;

import jpanamedquery.AddressJPA;
import jpanamedquery.DepartmentJPA;
import jpanamedquery.Phone;
import jpanamedquery.Professor;
import test.TransactionalSetup;

public class PersonDaoImpl extends TransactionalSetup{
	@Test
  public void test() {
    prepareData();
    
    Object l = em.createNamedQuery("findSalary").getResultList().get(0);
    List<Phone> resultList = em.createNamedQuery("findAllPhones", Phone.class).getResultList();
    for (Phone phone : resultList) {
		printResult(phone);
	}
    
    List resultList2 = em.createNamedQuery("Phone.nativeSQL").getResultList();
    for (Object object : resultList2) {
		printResult(object);
	}
    
    List<Phone> resultList3 = em.createNamedQuery("Phone.getAllProfesors").getResultList();
    for (Phone phone : resultList3) {
		System.out.println(phone + " With Person: " + phone.getProfessor());
	}
    
    em.flush();
    em.clear();
    
    List<Phone> resultList4 = em.createNamedQuery("Phone.getSomeInfo").getResultList();
    for (Phone phone : resultList4) {
		System.out.println(phone.getType() + "**********" + phone.getProfessor());
	}
    
//    printResult(l);

  }

  private void prepareData() {
    AddressJPA address = new AddressJPA();
    address.setState("BC");
    AddressJPA address1 = new AddressJPA();
    address1.setState("IS");
    
    Professor p = new Professor();
    p.setId(0);
    p.setName("TOM");
    p.setSalary(1111L);
    p.setAddress(address);
    
    Professor p1 = new Professor();
    p1.setId(1);
    p1.setName("Gigel");
    p1.setSalary(1000L);
    p1.setAddress(address1);

    DepartmentJPA d = new DepartmentJPA();
    d.setId(1);
    d.setName("Design");

    p.setDepartment(d);
    d.getProfessors().add(p);

    Phone phone = new Phone();
    phone.setId(1);
    phone.setNumber("111-111-1111");
    phone.setProfessor(p);
    phone.setType("Mobile");
    
    Phone phone1 = new Phone();
    phone1.setId(2);
    phone1.setNumber("111-111-1112");
    phone1.setProfessor(p);
    phone1.setType("FixPhone");
    
    Phone phone2 = new Phone();
    phone2.setId(3);
    phone2.setNumber("111-111-1113");
    phone2.setProfessor(p1);
    phone2.setType("Fix");
    
    Phone phone3 = new Phone();
    phone3.setId(4);
    phone3.setNumber("111-111-1114");
    phone3.setProfessor(p1);
    phone3.setType("Mobile");
    
    em.persist(p);
    em.persist(p1);
    em.persist(phone);
    em.persist(phone1);
    em.persist(phone2);
    em.persist(phone3);
    em.persist(address);
    em.persist(address1);
    em.persist(d);
  }

  private static void printResult(Object result) {
    if (result == null) {
      System.out.print("NULL");
    } else if (result instanceof Object[]) {
      Object[] row = (Object[]) result;
      System.out.print("[");
      for (int i = 0; i < row.length; i++) {
        printResult(row[i]);
      }
      System.out.print("]");
    } else if (result instanceof Long || result instanceof Double
        || result instanceof String) {
      System.out.print(result.getClass().getName() + ": " + result);
    } else {
      System.out.print(result);
    }
    System.out.println();
  }
}