package onetomany;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="PersonOneToMany")
public class PersonOneToMany {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="Person_ID")
  private long id;
   
  private String name;
  
  @ManyToOne
  @JoinColumn(name="department_id")
  private Department department;
  
  public PersonOneToMany() {}

  public PersonOneToMany(String name) {
    this.name = name;
  }


  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
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