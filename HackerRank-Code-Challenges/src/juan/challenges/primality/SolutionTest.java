package juan.challenges.primality;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testIsPrime() {
		assertTrue(Solution.isPrime(2));
//		assertTrue(Solution.isPrime(5));
//		assertFalse(Solution.isPrime(12));
//		assertTrue(Solution.isPrime(17));
//		assertFalse(Solution.isPrime(15));
//		assertTrue(Solution.isPrime(23));
//		assertFalse(Solution.isPrime(49));
//		assertFalse(Solution.isPrime(979));
	}
}
