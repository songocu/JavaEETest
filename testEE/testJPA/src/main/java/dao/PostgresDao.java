package dao;

import java.sql.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import model.Person;

@Stateless
public abstract class PostgresDao {
	
	private static final String PERSISTENCE_UNIT_NAME = "managedPersistenceUnitPostgre";
	@EJB
	private PostgresDao postgresDao;

	@PersistenceContext(unitName = PERSISTENCE_UNIT_NAME)
	private EntityManager em;
	
	public EntityManager getEm() {
		return em;
	}

	public void create () {
	}
	
	public void createUsersAndThrowException(){
	}
	
	@Transactional(value=TxType.REQUIRES_NEW)
	public void createAnotherUser () {
		Person person2=new Person();
		person2.setName("Gigel2"+new Date(0).getTime());
		em.persist(person2);
	}
	
	public void delete() {
	}
	
	public abstract List<Person> list();
	
	
	public void changeUser(Integer id,String text) {
	}
	
	

}
