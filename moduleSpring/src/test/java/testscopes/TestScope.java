package testscopes;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import applicationcontextbuild.ApplicationContextBuild;
import initialtest.Triangle;

public class TestScope extends ApplicationContextBuild {
  @Test
  public void testScopeSingleton(){
	 Triangle triangle= (Triangle)context.getBean("triangle");
	 triangle.setType("drept");
	 Triangle triangle2= (Triangle) context.getBean("triangle");
	 assertTrue("Triangle instance is not a singleton", triangle.equals(triangle2) && triangle.hashCode()==triangle2.hashCode());
  }
  
  @Test
  public void testScopePrototype(){
	 Triangle triangle= (Triangle)context.getBean("triangle_prototype");
	 triangle.setType("drept");
	 Triangle triangle2= (Triangle) context.getBean("triangle_prototype");
	 assertTrue("Triangle instance is not a prototype", !triangle.equals(triangle2) && !(triangle.hashCode()==triangle2.hashCode()));
  }
  
}
