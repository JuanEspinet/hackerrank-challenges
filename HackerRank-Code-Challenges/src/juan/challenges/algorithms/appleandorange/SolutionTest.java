package juan.challenges.algorithms.appleandorange;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SolutionTest {
	
	public House testHouse;
	public FruitTree appleTree;
	public FruitTree orangeTree;

	@Before
	public void setUp() throws Exception {
		testHouse = new House(-1, 5);
		appleTree = new FruitTree(-4);
		orangeTree = new FruitTree(12);
	}
	
	@Test
	public void testIsOnRoof() {
		assertFalse(testHouse.isOnHouse(-2));
		assertTrue(testHouse.isOnHouse(-1));
		assertFalse(testHouse.isOnHouse(6));
		assertTrue(testHouse.isOnHouse(3));
		assertTrue(testHouse.isOnHouse(5));
	}
	
	@Test
	public void testDropAllFruit() {
		int[] fruitPositions = {-1,1,-7,3,-8};
	
		assertEquals(1, testHouse.dropAllFruit(fruitPositions, appleTree));

		assertEquals(2, testHouse.dropAllFruit(fruitPositions, orangeTree));
	}

	@Test
	public void testDropFuit() {
		assertEquals(-4, appleTree.dropFruit(0));
		assertEquals(12, orangeTree.dropFruit(0));
		
		assertEquals(0, appleTree.dropFruit(4));
		assertEquals(16, orangeTree.dropFruit(4));
		
		assertEquals(-10, appleTree.dropFruit(-6));
		assertEquals(6, orangeTree.dropFruit(-6));
	}
}
