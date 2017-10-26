package testIDS;

import java.util.UUID;

import javax.persistence.Entity;

@Entity
public class TestIDSUsingUUID {

	@javax.persistence.Id
	private String id;
	
	private String name;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TestIDSUsingUUID(){
		this.id = UUID.randomUUID().toString();
	}
	
    public int hashCode(){
    	return id.hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
    	if(this == obj) return true;
    	if(obj == null) return false;
    	if(!(obj instanceof TestIDSUsingUUID)) return false;
    	TestIDSUsingUUID other=(TestIDSUsingUUID) obj;
    	return getId().equals(other.getId());
     }
}
