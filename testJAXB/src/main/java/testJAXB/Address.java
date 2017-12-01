package testJAXB;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Address {

	
	private String street;
	private Integer number;
	private String bloc;
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getBloc() {
		return bloc;
	}
	public void setBloc(String bloc) {
		this.bloc = bloc;
	}
	
	
	
	
}
