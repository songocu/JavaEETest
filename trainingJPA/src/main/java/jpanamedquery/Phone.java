package jpanamedquery;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FetchType;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;

@SqlResultSetMapping(name = "PhoneMapping", entities = @EntityResult(entityClass = Phone.class, fields = {
		@FieldResult(name = "type", column = "type"), 
		@FieldResult(name = "employee_id", column = "employee_id"),
		@FieldResult(name = "id", column = "id")
		}))
@Entity(name = "Phone")
@NamedQuery(name = "findAllPhones", query = "SELECT p FROM Phone p")
@NamedNativeQueries({ @NamedNativeQuery(name = "Phone.nativeSQL", query = "SELECT type FROM phone"),
		@NamedNativeQuery(name = "Phone.getAllProfesors", query = "SELECT * FROM phone", resultClass = Phone.class),
		@NamedNativeQuery(name = "Phone.getSomeInfo", query = "SELECT p.id,p.type,p.employee_id FROM phone p", resultSetMapping = "PhoneMapping") })
public class Phone {
	@Id
	private long id;
	private String number;
	private String type;

	@Column(insertable = false, updatable = false)
	private Integer employee_id;

	public Integer getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}

	@ManyToOne
	Professor employee;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String phoneNo) {
		this.number = phoneNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String phoneType) {
		this.type = phoneType;
	}

	public Professor getProfessor() {
		return employee;
	}

	public void setProfessor(Professor employee) {
		this.employee = employee;
	}

	public String toString() {
		return "Phone id: " + getId() + ", no: " + getNumber() + ", type: " + getType();
	}
}