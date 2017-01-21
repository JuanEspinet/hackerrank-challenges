package juan.challenges.binarytree;

import juan.challenges.binarytree.Node;

/**
 * Challenge description at https://www.hackerrank.com/challenges/ctci-is-binary-search-tree
 * 
 *
 */
public class BinaryTreeChallenge {
	boolean checkBST(Node root) {
		return isBinarySearch(root, -1, -1);
	}
	
    boolean isBinarySearch(Node current, int min, int max) {
    	
    	current.printNode();
        
        if (current.left != null &&
    			(!leftValueMatch(current, min, max)
    					|| !isBinarySearch(current.left, min, current.data))) {
        	System.out.println("Fail left on node " + current.data);
			return false;
		}
    	
    	if (current.right != null &&
    			(!rightValueMatch(current, min, max)
    					|| !isBinarySearch(current.right, current.data, max))) {
    		System.out.println("Fail right on node " + current.data);
    		return false;
    	}
        
        return true;
    }
    
    boolean leftValueMatch(Node current, int min, int max) {
    	boolean match = current.left.data < current.data;
    	
    	if (min > -1) {
    		match = match && current.left.data > min;
		}
    	
    	if (max > -1) {
			match = match && current.left.data < max;
		}
    	
    	return match;
    }
    
    boolean rightValueMatch(Node current, int min, int max) {
    	boolean match = current.right.data > current.data;
    	
    	if (min > -1) {
    		match = match && current.right.data > min;
		}
    	
    	if (max > -1) {
			match = match && current.right.data < max;
		}
    	
    	return match;
    }
}

class Node {
	 int data;
	 Node left;
	 Node right;
	 
	 Node(int num) {
		 this.data = num;
		 this.left = null;
		 this.right = null;
	 }
	 
	 public void addNode(int num) {
		 if (num < this.data) {
			 if (this.left == null) {
				 this.left = new Node(num);
			 } else {
				 this.left.addNode(num);
			 }
		 } else {
			 if (this.right == null) {
				 this.right = new Node(num);
			 } else {
				 this.right.addNode(num);
			 }
		 }
	 }
	 
	 public void printTree() {
		this.printNode();
		
		if (this.left != null) {
			this.left.printTree();
		}
		
		if (this.right != null) {
			this.right.printTree();
		}
	 }
	 
	 public void printNode() {
		String left = this.left == null ? "null" : Integer.toString(this.left.data);
		String right = this.right == null ? "null" : Integer.toString(this.right.data);
		System.out.println("Node: " + this.data + " Left-> " + left + " Right -> " + right);
	 }
}
