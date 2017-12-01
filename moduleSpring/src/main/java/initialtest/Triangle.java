package initialtest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;

@Scope("prototype")
public class Triangle {
	@Value(value = "110")
	private int latNumber;
	@Value(value = "equilateral")
	private String type;
	
	public Triangle(){};
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + latNumber;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Triangle other = (Triangle) obj;
		if (latNumber != other.latNumber)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	public void draw() {
		System.out.println("Triangle contains: latNumber=" + latNumber + " and type is="+type);
	}
	
	public Triangle(int latNumber, String type) {
		this.latNumber = latNumber;
		this.type = type;
	}
	public int getLatNumber() {
		return latNumber;
	}
	public void setLatNumber(int latNumber) {
		this.latNumber = latNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
