package test;

import org.junit.Test;
import org.unitils.reflectionassert.ReflectionAssert;

import testenum.Movie;
import testenum.Rating;

public class TestEnum extends TransactionalSetup {

	@Test
	public void testEnumConnection() {
		// CREATE
		Movie movie1=new Movie();
		movie1.setDirector("John");
		movie1.setRating(Rating.G);
		movie1.setTitle("La scaldat");
		movie1.setYear(2011);
		//Movie movie1 = new Movie("John", "La scaldat", 100, Rating.G);
		em.persist(movie1);
		em.flush();
		
		// TEST CREATE => READ		
		em.clear();
		Movie testReadMovie = em.find(Movie.class, movie1.getId());
		ReflectionAssert.assertLenientEquals(movie1, testReadMovie);
		
	}

}
