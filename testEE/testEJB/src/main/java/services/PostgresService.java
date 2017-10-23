package services;

import java.sql.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.PostgresDao;
import model.Person;

@Stateless
public class PostgresService {
	
	@EJB
	PostgresDao dao;

	public void create() {
		dao.create();
		Person person=new Person();
		person.setName("Gigel "+new Date(0).getTime());
		dao.getEm().persist(person);
	}
	
	public void createUsersAndThrowException() {
		dao.createUsersAndThrowException();
		Person person1=new Person();
		person1.setName("Gigel1"+new Date(0).getTime());
		dao.getEm().persist(person1);
		dao.createAnotherUser();
		throw new RuntimeException();
	}

	public List<Person> list() {
		return dao.getEm().createQuery("select t from Person t",Person.class).getResultList();
	}

	public void delete() {
		dao.getEm().createQuery("delete from Person").executeUpdate();
	}
	
	public void changeUser(Integer id, String text) {
		Person personToBeReplaced= dao.getEm().find(Person.class,id);
		personToBeReplaced.setName(text);
	}
	
}
