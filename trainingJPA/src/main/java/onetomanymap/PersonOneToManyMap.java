package onetomanymap;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PersonOneToManyMap {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private long id;
   
  private String name;
  
  @ManyToOne
  private DepartmentOneToManyMap department;
  
  public PersonOneToManyMap() {}

  public PersonOneToManyMap(String name) {
    this.name = name;
  }


  public DepartmentOneToManyMap getDepartment() {
    return department;
  }

  public void setDepartment(DepartmentOneToManyMap department) {
    this.department = department;
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
    return "Person [id=" + id + ", name=" + name + "]";
  }

}