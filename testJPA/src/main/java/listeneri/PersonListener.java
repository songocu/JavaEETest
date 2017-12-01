package listeneri;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import model.Person;

public class PersonListener {
	
	@PrePersist
	public void prePersint (Person person) {
		System.out.println("pre persist");
	}
	@PreUpdate
	public void preUpdate(Person person){
		System.out.println("pre update");
	}
	@PreRemove
	public void preRemove(Person person){
		System.out.println("pre remove");
	}

}
