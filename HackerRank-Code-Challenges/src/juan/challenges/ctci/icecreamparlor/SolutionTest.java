package juan.challenges.ctci.icecreamparlor;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	Flavor[] flavors;
	
	
	@Before
	public void setUp() throws Exception {
		flavors = new Flavor[5];
		int[] costList = {2, 3, 2, 5, 1};
		
		for (int i = 0; i < 5; i++) {
			flavors[i] = new Flavor(i + 1, costList[i]);
		}
	}

	@Test
	public void testSearchForPrice() {
		// the method we are testing requires a pre-sorted array
		Arrays.sort(flavors);
		
		assertEquals(null, Solution.searchForPrice(10, 0, flavors.length - 1, flavors));
		assertEquals(2, Solution.searchForPrice(3, 0, flavors.length - 1, flavors).id);
		assertEquals(4, Solution.searchForPrice(5, 0, flavors.length - 1, flavors).id);
		assertEquals(5, Solution.searchForPrice(1, 0, flavors.length - 1, flavors).id);
		
		/* With multiple IDs with the same cost
		 * which ID is found first is not guaranteed
		 * so the case below could find either ID
		 * 1 or 3.
		 */
		int costTwo = Solution.searchForPrice(2, 0, flavors.length - 1, flavors).id;
		assertTrue(costTwo == 1 || costTwo == 3);
	}

	@Test
	public void testFindPairForPrice() {
		Flavor[] pair = Solution.findPairForPrice(6, flavors);
		
		// check to make sure the output is formatted correctly
		assertEquals(2, pair.length);

		assertTrue(pair[0].id < pair[1].id);
		assertEquals(6, pair[0].cost + pair[1].cost);
		assertEquals(5, pair[0].cost);
		assertEquals(1, pair[1].cost);
		
		pair = Solution.findPairForPrice(8, flavors);
		
		assertTrue(pair[0].id < pair[1].id);
		assertEquals(8, pair[0].cost + pair[1].cost);
		assertEquals(3, pair[0].cost);
		assertEquals(5, pair[1].cost);
		
		// test with multiple flavors at the same price
		flavors = new Flavor[7];
		int[] costList = {2, 2, 2, 1, 1, 1, 1};
		
		for (int i = 0; i < 7; i++) {
			flavors[i] = new Flavor(i + 1, costList[i]);
		}
		
		pair = Solution.findPairForPrice(4, flavors);
		
		assertTrue(pair[0].id < pair[1].id);
		assertEquals(4, pair[0].cost + pair[1].cost);
		assertEquals(2, pair[0].cost);
		assertEquals(2, pair[1].cost);
	}
}
