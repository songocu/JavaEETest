package testListeneri;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class PersonListener {
	
	@PrePersist
	public void prePersint (Person person) {
		System.out.println("pre persist");
		person.setCurrentAssign("pre persist");
	}
	@PreUpdate
	public void preUpdate(Person person){
		System.out.println("pre update");
		person.setCurrentAssign("pre update");
	}
	@PreRemove
	public void preRemove(Person person){
		System.out.println("pre remove");
	}

}
