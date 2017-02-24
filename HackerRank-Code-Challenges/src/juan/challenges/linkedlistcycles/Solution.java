package juan.challenges.linkedlistcycles;

import java.sql.Struct;
import java.util.HashSet;

/**
 * Solution to hackerrank challenge found at:
 * @author juanespinet
 *
 */
public class Solution {
	/*
	Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

	A Node is defined as: 
	    class Node {
	        int data;
	        Node next;
	    }
	*/

	boolean hasCycle(Node head) {
		HashSet<Node> visited = new HashSet<Node>();
		Node current = head;
		
		while (current != null) {
			if (visited.contains(current)) {
				return true;
			}
			
			visited.add(current);
			current = current.next;
		}
		
		return false;
	}
}

class Node {
	int data;
	Node next;
}