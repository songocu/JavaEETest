package manytomanymap;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class PersonManyToManyMap {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private long id;
   
  private String name;
  
  @ManyToMany
  private Set<DepartmentManyToManyMap> departments = new HashSet<DepartmentManyToManyMap>();
  
  public PersonManyToManyMap() {}

  public PersonManyToManyMap(String name) {
    this.name = name;
  }

 
  public Set<DepartmentManyToManyMap> getDepartments() {
    return departments;
  }

  public void setDepartments(Set<DepartmentManyToManyMap> departments) {
    this.departments = departments;
  }

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
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
    return "Person [id=" + id + ", name=" + name + ", departments="
        + departments + "]";
  }


}