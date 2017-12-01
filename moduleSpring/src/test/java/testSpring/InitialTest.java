package testSpring;

import org.junit.Test;

import applicationcontextbuild.ApplicationContextBuild;
import initialtest.Triangle;

public class InitialTest extends ApplicationContextBuild{

    @Test
	public void testInitial(){
		Triangle triangle= (Triangle) context.getBean("triangle");
		triangle.draw();
	}
	
	
}
