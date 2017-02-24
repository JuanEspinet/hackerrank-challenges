package juan.challenges.ctci.contacts;

import java.util.*;
/*
 * Challenge description on https://www.hackerrank.com/challenges/ctci-contacts
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ContactTrie contacts = new ContactTrie();
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            
            if (op.equals("add")) {
				contacts.add(contact);
			} else if (op.equals("find")) {
				System.out.println(contacts.find(contact));
			}
        }
        in.close();
    }
}

/**
 * A trie for storing information
 * on number of times a given
 * 'contact' has been added to this
 * application and making that information
 * easily retrievable.
 * 
 * @author juanespinet
 *
 */
class ContactTrie {
	protected Node root;
	
	public ContactTrie() {
		root = new Node();
	}
	
	/**
	 * Adds a single name to this tree.
	 * Name strings must consist of
	 * lower case english letters only.
	 * 
	 * @param name The name to be added
	 */
	public void add(String name) {
    	// start with root
		Node current = this.root;
		
		// add entries one character at a time
		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			// attempt to add node
			Node next = current.addChild(c);
			// move to next node in case of more chars
			current = next;
		}
    }
    
	/**
	 * Retrieves the number of occurrences
	 * of a partial string within already
	 * added contacts.
	 * 
	 * @param partial A string to search
	 * @return int The number of occurrences
	 */
    public int find(String partial) {
    	// start with root
    	Node current = this.root;
    	
    	// traverse the node tree one level per char
    	for (int i = 0; i < partial.length(); i++) {
			char c = partial.charAt(i);
			// search node for character
			Node next = current.getChild(c);
			if (next == null) {
				// character not found, no occurrences of this partial
				return 0;
			}
			// character found move to the next character
			current = next;
		}
    	
    	return current.getUseCount();
    }
}


/**
 * A single node for the contact trie for this
 * contacts application.
 */
class Node {
	/**
	 * The character this node represents in this branch.
	 */
	final Character value;
	
	/**
	 * The number of entries that have used this node.
	 */
	protected int useCount;
	
	/**
	 * An array of all child nodes.
	 * Array indexes are calculated based
	 * on character code, thus this array
	 * is effectively keyed by character.
	 */
	protected Node[] children;
	
	public Node(char value) {
		this.value = value;
		this.useCount = 1;
		this.children = new Node[26];
	}
	
	public Node() {
		this.value = null;
		this.children = new Node[26];
	}
	
	/**
	 * Gets a child based on a character
	 * value key.
	 */
	public Node getChild(char key) {
		return this.children[this.caculateChildIndex(key)];
	}
	
	/**
	 * Updates the children for this node
	 * to include the 
	 * 
	 * @param child
	 */
	protected void insertChild(Node child) {
		this.children[this.caculateChildIndex(child.value)] = child;
	}
	
	/**
	 * Calculates the index in the child array
	 * for a node with a given character value;
	 * 
	 * @param char key Character value
	 * @return int The index
	 */
	protected int caculateChildIndex(char key) {
		return (int) key - 'a';
	}
	
	/**
	 * Adds a child to this node for the
	 * character value specified, or gets
	 * the existing child node for that char
	 * and increments the use count.
	 * 
	 * @param key The character value of the node to be added.
	 * @return Node
	 */
	public Node addChild(char key) {
		// Check if a node exists for this char
		Node child = this.getChild(key);
		
		if (child == null) {
			// does not exist, create new child node
			child = new Node(key);
			this.insertChild(child);
		} else {
			// exists, increment count
			child.incrementUseCount();
		}
		
		return child;
	}
	
	/**
	 * Gets the number of entries that use this node. 
	 */
	public int getUseCount() {
		return useCount;
	}
	
	/**
	 * Increases the count of entries that use this node
	 * by one.
	 */
	public void incrementUseCount() {
		this.useCount++;
	}
}