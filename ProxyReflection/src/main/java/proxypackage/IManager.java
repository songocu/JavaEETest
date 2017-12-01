package proxypackage;

public interface IManager extends IEmployee {
	public String getTitle();

	public String[] getDepartments();

	public void setTitle(String title);

	public void setDepartments(String[] departments);
}