package onetoonerelationshipbidirectional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class EmployeeAddressOneToOneBidirectional {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="ADDRESS_ID")
	private int id;
	@OneToOne(fetch=FetchType.EAGER, mappedBy="address")
	private EmployeeBidirectional employeeBidirectional;
	
	private String street;
	private String city;
	private int zipCode;
	
	
	
	public EmployeeBidirectional getEmployeeBidirectional() {
		return employeeBidirectional;
	}
	public void setEmployeeBidirectional(EmployeeBidirectional employeeBidirectional) {
		this.employeeBidirectional = employeeBidirectional;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	
}
