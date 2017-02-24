package juan.challenges.ctci.contacts;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NodeTest {
	
	Node testNode;

	@Before
	public void setUp() throws Exception {
		testNode = new Node('a');
		String testCharacters = "abcdefghjklmnop";
		for (int i = 0; i < testCharacters.length(); i++) {
			char c = testCharacters.charAt(i);
			testNode.children[(int) c - 'a'] = new Node(c);
		}
	}

	@Test
	public void testGetUseCount() {
		assertEquals(1, testNode.getUseCount());
	}
	
	@Test
	public void testIncrementCount() {
		testNode.incrementUseCount();
		assertEquals(2, testNode.useCount);
	}
	
	@Test
	public void testGetChild() {
		Node child = testNode.getChild('a');
		
		assertTrue(child.value == 'a');
	}
	
	@Test 
	public void testCalculateChildIndex() {
		assertEquals(0, testNode.caculateChildIndex('a'));
		assertEquals(2, testNode.caculateChildIndex('c'));
	}
	
	@Test
	public void testAddChild() {
		Node child = testNode.addChild('i');
		assertFalse(testNode.getChild('i') == null);
		assertTrue('i' == child.value);
		assertEquals(1, child.useCount);
		
		child = testNode.addChild('a');
		assertEquals(2, child.useCount);
	}

}
