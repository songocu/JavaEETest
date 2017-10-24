package test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;

import org.junit.Test;
import org.unitils.reflectionassert.ReflectionAssert;

import testDate.DatesPojo;

public class TestDate extends TransactionalSetup{
	
	@Test
	public void testVariosDateFormat(){
		DatesPojo e=new DatesPojo();
		e.setDate(LocalDate.now());
		e.setTime(LocalTime.now());
		e.setDateTime(LocalDateTime.now());
		e.setOffsetTime(OffsetTime.now());
		e.setOffsetDateTime(OffsetDateTime.now());
		 
		em.persist(e);
		em.flush();
		
		// TEST CREATE => READ
		em.clear();
//		SimpleEntity existingEntity1 = em.find(SimpleEntity.class, createdEntity.getId());
//		ReflectionAssert.assertLenientEquals(createdEntity, existingEntity1);
		DatesPojo datesPojo=em.find(DatesPojo.class, e.getId());
		ReflectionAssert.assertLenientEquals(datesPojo, e);
		
	}

}
