package juan.challenges.linkedlistcycles;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SolutionTest {
	
	Solution s = new Solution();
	Node testList = new Node();
	Node testList2 = new Node();

	@Before
	public void setUp() throws Exception {
		testList.next = new Node();
		testList.next.next = new Node();
		testList.next.next.next = testList;
		
		testList2.next = new Node();
		testList2.next.next = new Node();
		testList2.next.next.next = new Node();
	}

	@Test
	public void testEquality() {
		assertFalse(testList.equals(testList.next));
		assertTrue(testList.equals(testList));
		assertTrue(testList.equals(testList.next.next.next));
	}
	
	@Test
	public void testHasCycle() {
		assertTrue(s.hasCycle(testList));
		assertFalse(s.hasCycle(testList2));
	}

}
