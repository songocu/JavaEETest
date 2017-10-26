package onetomanylist;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PrintJob {
    @Id private int id;

    @ManyToOne(cascade={CascadeType.PERSIST})
    private PrintQueue queue;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PrintQueue getQueue() {
        return queue;
    }

    public void setQueue(PrintQueue queue) {
        this.queue = queue;
    }
    
    public String toString(){
    	return "PrintJob Id: " + this.getId() + " PrintQue" + this.getQueue();
    }
}