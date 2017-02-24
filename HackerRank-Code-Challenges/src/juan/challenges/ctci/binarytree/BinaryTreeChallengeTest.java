package juan.challenges.ctci.binarytree;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BinaryTreeChallengeTest {
	
	Node testTreeGood;
	Node testTreeBad;
	Node testTreeBad2;
	BinaryTreeChallenge testBed;

	@Before
	public void setUp() throws Exception {
		testBed = new BinaryTreeChallenge();
		int[] badSet = {7,6,8,2,5,4,2,3,5};
		int[] goodSet = {1,2,3,4,5,6,7,8};
		int[] badSet2 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,17,16,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
		testTreeGood = populateBinaryTree(goodSet);
		testTreeBad = populateBinaryTree(badSet);
		testTreeBad2 = populateBinaryTree(badSet2);
	}
	
	@Test
	public void testPopulateBinaryTree() {
//		testTreeGood.printTree();
		assertTrue(testTreeGood.data == 5);
	}

	@Test
	public void testCheckBST() {
		assertTrue(testBed.checkBST(testTreeGood));
		assertFalse(testBed.checkBST(testTreeBad));
		assertFalse(testBed.checkBST(testTreeBad2));
	}
	
	@Test
	public void testLeftValueMatch() {
		Node node1 = new Node(5);
		node1.left = new Node(4);
		
		assertTrue(testBed.leftValueMatch(node1, -1, -1));
		assertTrue(testBed.leftValueMatch(node1, 0, 6));
		assertFalse(testBed.leftValueMatch(node1, 4, 6));
		assertFalse(testBed.leftValueMatch(node1, 2, 3));
		
		node1.left = new Node(6);
		assertFalse(testBed.leftValueMatch(node1, -1, -1));
		assertFalse(testBed.leftValueMatch(node1, 0, 6));
	}
	
	@Test
	public void testRightValueMatch() {
		Node node1 = new Node(5);
		node1.right = new Node(6);
		
		assertTrue(testBed.rightValueMatch(node1, -1, -1));
		assertTrue(testBed.rightValueMatch(node1, 0, 7));
		assertFalse(testBed.rightValueMatch(node1, 7, 8));
		assertFalse(testBed.rightValueMatch(node1, 2, 3));
		
		node1.right = new Node(4);
		assertFalse(testBed.rightValueMatch(node1, -1, -1));
		assertFalse(testBed.rightValueMatch(node1, 0, 7));
	}
	
	public Node populateBinaryTree(int[] nodeInts) {
		int midIndex = Math.floorDiv(nodeInts.length, 2);
		int[] leftSlice = midIndex > 0 ? createSubArray(0, midIndex - 1, nodeInts) : null;
		int[] rightSlice = midIndex < nodeInts.length - 1 ? createSubArray(midIndex + 1, nodeInts.length - 1, nodeInts) : null;
		
		Node current = new Node(nodeInts[midIndex]);
		
		if (leftSlice != null) {
			current.left = populateBinaryTree(leftSlice);
		}
		
		if (rightSlice != null) {
			current.right = populateBinaryTree(rightSlice);
		}
		
		return current;
	}
	
	public int[] createSubArray(int startIndex, int stopIndex, int[] parentArray) {
		int size = stopIndex - startIndex + 1;
		int[] subArray = new int[size];
		
		for (int i = 0, j = startIndex; i < size; i++, j++) {
			int newval = parentArray[j];
			subArray[i] = newval;
		}
		
		return subArray;
	}
}
