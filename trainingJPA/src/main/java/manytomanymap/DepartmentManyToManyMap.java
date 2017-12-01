package manytomanymap;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class DepartmentManyToManyMap implements java.io.Serializable{

	private static final long serialVersionUID = 4117172295951473690L;

@Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private long id;
  
  private String name;
  
  @ManyToMany
  private Set<PersonManyToManyMap> persons = new HashSet<PersonManyToManyMap>();
  
  public Set<PersonManyToManyMap> getPersons() {
    return persons;
  }

  public void setPersons(Set<PersonManyToManyMap> persons) {
    this.persons = persons;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Department [id=" + id + ", name=" + name + ", persons=" + persons
        + "]";
  }

}