package testreflection;

import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import reflection.ConcreteClass;

@SuppressWarnings("deprecation")
public class TestConcreteClass {
	Class<?> concreteClass;
	
	@Before
	public void setUp() throws Exception{
		concreteClass = new ConcreteClass(5).getClass();

			concreteClass = Class.forName("reflection.ConcreteClass");

		
		System.out.println(concreteClass.getCanonicalName()+ " setUp completed");
	}
	
	@Test
	public void testReflectionClassNameLikeTheNameOfConcreteClass () {
		assertEquals("reflection.ConcreteClass", concreteClass.getCanonicalName());
	}
	
	@Test
	public void testSuperClassLikeTheNameOfReflectionSuperClass(){
		assertEquals("reflection.BaseClass", concreteClass.getSuperclass().getCanonicalName());
	}
	
	@Test
	public void testMethod1() throws Exception{
       Method[] publicMethods = Class.forName("reflection.ConcreteClass").getMethods();
       System.out.println(Arrays.toString(publicMethods));
	}
	
	
}
