package juan.challenges.contacts;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SolutionTest {
	
	ContactTrie testContacts;

	@Before
	public void setUp() throws Exception {
		testContacts = new ContactTrie();
		String testCharacters = "abbbcdefghjklmnop";
		for (int i = 0; i < testCharacters.length(); i++) {
			char c = testCharacters.charAt(i);
			testContacts.root.addChild(c);
		}
		testContacts.root.getChild('b').addChild('e');
	}

	@Test
	public void testAdd() {
		Node root = testContacts.root;
		testContacts.add("a");
		int count = root.getChild('a').getUseCount();
		assertEquals(2, count);
		
		testContacts.add("bel");
		count = root.getChild('b').getChild('e').getChild('l').getUseCount();
		assertEquals(1, count);
	}
	
	@Test 
	public void testFind() {
		int count = testContacts.find("a");
		assertEquals(1, count);
		
		count = testContacts.find("b");
		assertEquals(3, count);
		
		count = testContacts.find("be");
		assertEquals(1, count);
		
		count = testContacts.find("beltsaver");
		assertEquals(0, count);
	}

}
