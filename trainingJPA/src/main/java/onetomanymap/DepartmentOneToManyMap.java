package onetomanymap;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

@Entity
public class DepartmentOneToManyMap implements java.io.Serializable{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private long id;
  
  private String name;
  
  @OneToMany(targetEntity=PersonOneToManyMap.class, mappedBy="department")
  @MapKey(name="id")
  private Set<PersonOneToManyMap> persons = new HashSet<PersonOneToManyMap>();
  
  public Set<PersonOneToManyMap> getPersons() {
    return persons;
  }

  public void setPersons(Set<PersonOneToManyMap> persons) {
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