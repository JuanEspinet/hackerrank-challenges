package juan.challenges.recursionstaircase;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindWaysUp() {
		assertEquals(1, Solution.findWaysUp(1, null));
		assertEquals(2, Solution.findWaysUp(2, null));
		assertEquals(1, Solution.findWaysUp(0, null));
		assertEquals(4, Solution.findWaysUp(3, null));
		assertEquals(44, Solution.findWaysUp(7, null));
	}

}
