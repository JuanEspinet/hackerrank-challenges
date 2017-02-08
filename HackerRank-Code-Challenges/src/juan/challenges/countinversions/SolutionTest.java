package juan.challenges.countinversions;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class SolutionTest {
	
	int[] array1;
	int leftStart;
	int rightEnd;
	

	@Before
	public void setUp() throws Exception {
		array1 = new int[]{1, 3, 7, 5, 2, 4, 6};
		leftStart = 0;
		rightEnd = array1.length - 1;
	}

	@Test
	public void testMergeArraySections() {
		// merge sections expects the two halves to be pre-sorted
		// so it should give this output given two halves that
		// are not already sorted
		int[] expected = {1, 2, 3, 4, 6, 7, 5};
		
		Solution.mergeArraySections(array1, leftStart, rightEnd, null);
		
		assertArrayEquals(expected, array1);
	}

}
