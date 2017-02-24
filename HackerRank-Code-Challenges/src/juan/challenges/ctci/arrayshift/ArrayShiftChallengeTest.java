package juan.challenges.ctci.arrayshift;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import juan.challenges.ctci.arrayshift.ArrayShiftChallenge;

public class ArrayShiftChallengeTest {
	
	ArrayShiftChallenge testClass;

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testRotateArray() {
		testClass = new ArrayShiftChallenge();
		int[] in = {1, 2, 3, 4, 5};
		int[] out = testClass.rotateArray(in, 1);
		int[] expected = {2, 3, 4, 5, 1};
		assertArrayEquals(expected, out);
		
		int[] inTwo = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		out = testClass.rotateArray(inTwo, 16);
		int[] expectedTwo = {5, 6, 7, 8, 9, 10, 11, 12, 1, 2, 3, 4};
		assertArrayEquals(expectedTwo, out);
		
		int[] inThree = {41, 73, 89, 7, 10, 1, 59, 58, 84, 77, 77, 97, 58, 1, 86, 58, 26, 10, 86, 51};
		out = testClass.rotateArray(inThree, 10);
		int[] expectedThree = {77, 97, 58, 1, 86, 58, 26, 10, 86, 51, 41, 73, 89, 7, 10, 1, 59, 58, 84, 77};
		assertArrayEquals(expectedThree, out);
	}

}
