package testJAXB;
import java.io.FileOutputStream;  
  
import javax.xml.bind.JAXBContext;  
import javax.xml.bind.Marshaller;  
  
  
public class ObjectToXml {  
public static void main(String[] args) throws Exception{  
    JAXBContext contextObj = JAXBContext.newInstance(Employee.class);  
  
    Marshaller marshallerObj = contextObj.createMarshaller();  
    marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
  
    Employee emp1=new Employee(1,"Vimal Jaiswal",50000);
    Address address1=new Address();
    address1.setBloc("A");
    address1.setNumber(100);
    address1.setStreet("Buridava");
    emp1.setAddress(address1);
    emp1.setSalary(400);
      
    FileOutputStream fileOutputStream = new FileOutputStream("employee.xml");
    marshallerObj.marshal(emp1, fileOutputStream); 
    marshallerObj.marshal(address1, fileOutputStream);
    System.out.println("Marshaller finished");
       
}  
}  