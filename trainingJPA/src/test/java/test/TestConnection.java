package test;

import org.junit.Test;
import org.unitils.reflectionassert.ReflectionAssert;

import entities.SimpleEntity;

public class TestConnection extends TransactionalSetup {

	@Test
	public void test() {

		// CREATE
		SimpleEntity createdEntity = new SimpleEntity();
		createdEntity.setName("EntityName");
		em.persist(createdEntity);
		em.flush();

		// TEST CREATE => READ
		em.clear();
		SimpleEntity existingEntity1 = em.find(SimpleEntity.class, createdEntity.getId());
		ReflectionAssert.assertLenientEquals(createdEntity, existingEntity1);

		// UPDATE
		em.clear();
		SimpleEntity updatedEntity = em.find(SimpleEntity.class, createdEntity.getId());
		updatedEntity.setName("gheorghe");
		em.merge(updatedEntity);
		em.flush();

		// TEST UPDATE => READ
		em.clear();
		SimpleEntity existingEntity2 = em.find(SimpleEntity.class, createdEntity.getId());

	}

}
