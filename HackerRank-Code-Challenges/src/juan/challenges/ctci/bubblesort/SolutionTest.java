package juan.challenges.ctci.bubblesort;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	int[] testArray;
	
	@Before
	public void setUp() throws Exception {
		testArray = new int[]{2,1,3,4,6,5};
	}

	@Test
	public void testSwap() {
		Solution.swap(0, 1, testArray);
		
		assertEquals(1, testArray[0]);
		assertEquals(2, testArray[1]);
	}

}
