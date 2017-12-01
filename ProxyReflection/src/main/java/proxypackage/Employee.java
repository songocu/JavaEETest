package proxypackage;

public class Employee extends Person {
	private String SSN;
	private String department;
	private float salary;

	public String getSSN() {
		return SSN;
	}

	public String getDepartment() {
		return department;
	}

	public float getSalary() {
		return salary;
	}

	public void setSSN(String ssn) {
		this.SSN = ssn;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}
}