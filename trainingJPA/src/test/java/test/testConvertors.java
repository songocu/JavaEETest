package test;

import java.awt.Color;

import org.junit.Test;
import org.unitils.reflectionassert.ReflectionAssert;

import testConvertors.RectangleEntity;

public class testConvertors extends TransactionalSetup {
	@Test
	public void testThatColorsAreConverted(){
		
		RectangleEntity rectangleEntity=new RectangleEntity();
		rectangleEntity.setColor("red");
		rectangleEntity.setX(100);
		rectangleEntity.setY(200);
		em.persist(rectangleEntity);
		em.flush();
		
		// TEST CREATE => READ
		em.clear();
		RectangleEntity rectangleEntity2=em.find(RectangleEntity.class, rectangleEntity.getId());
		ReflectionAssert.assertLenientEquals(rectangleEntity2, rectangleEntity);
	}
	
}
