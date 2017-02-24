package juan.challenges.ctci.countinversions;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class SolutionTest {
	
	MergeShiftCounter counter;
	int[] array1;
	int leftStart;
	int rightEnd;
	

	@Before
	public void setUp() throws Exception {
		counter = new MergeShiftCounter();
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
		
		counter.mergeArraySections(array1, leftStart, rightEnd, null);
		
		assertArrayEquals(expected, array1);
	}
	
	@Test
	public void testMergeSort() {
		int[] expected = {1, 2, 3, 4, 5, 6, 7};
		
		counter.mergeSort(array1, leftStart, rightEnd, null);
		
		assertArrayEquals(expected, array1);
	}
	
	@Test
	public void testCountShifts() {
		int[] array2 = {1, 1, 1, 2, 2}; 
		int[] array3 = {2, 1, 3, 1, 2}; 

		long shifts = counter.countShifts(array1);
		assertEquals(7, shifts);
		
		shifts = counter.countShifts(array2);
		assertEquals(0, shifts);
		
		shifts = counter.countShifts(array3);
		assertEquals(4, shifts);
	}
}
