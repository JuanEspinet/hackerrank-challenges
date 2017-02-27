package juan.challenges.algorithms.designerpdf;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SolutionTest {
	
	int[] testHeights;

	@Before
	public void setUp() throws Exception {
		testHeights = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
	}

	@Test
	public void testGetHeight() {
		assertEquals(1, Solution.getHeight('a', testHeights));
		assertEquals(2, Solution.getHeight('b', testHeights));
		assertEquals(5, Solution.getHeight('e', testHeights));
		assertEquals(11, Solution.getHeight('k', testHeights));
		assertEquals(26, Solution.getHeight('z', testHeights));
	}
	
	@Test
	public void testGetMaxHeight() {
		assertEquals(1, Solution.getMaxHeight("aaa", testHeights));
		assertEquals(2, Solution.getMaxHeight("aba", testHeights));
		assertEquals(5, Solution.getMaxHeight("aea", testHeights));
		assertEquals(11, Solution.getMaxHeight("cdk", testHeights));
		assertEquals(26, Solution.getMaxHeight("zad", testHeights));
	}
	
	@Test
	public void testGetWordArea() {
		assertEquals(3, Solution.getWordArea("aaa", testHeights));
		assertEquals(6, Solution.getWordArea("aba", testHeights));
		assertEquals(26, Solution.getWordArea("z", testHeights));
		assertEquals(78, Solution.getWordArea("zzz", testHeights));
		assertEquals(77, Solution.getWordArea("abkedef", testHeights));
	}

}
