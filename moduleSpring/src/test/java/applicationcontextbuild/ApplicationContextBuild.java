package applicationcontextbuild;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextBuild {
	public static ApplicationContext context;
	
	@BeforeClass
	public static void buildApplicationContext(){
		context = new ClassPathXmlApplicationContext("spring.xml");
	}
	
	@AfterClass
	public static void closeApplicationContext(){
		((ConfigurableApplicationContext)context).close();
	}
}
