package juan.challenges.ransomnote;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MagazineTest {
	
	Magazine testMagazine;

	@Before
	public void setUp() throws Exception {
		String[] words = {"Bleegh", "Bleugh", "blarg", "yep", "aaasavad", "yep"};
		testMagazine = new Magazine(words);
	}

	@Test
	public void testMagazine() {
		assertTrue(testMagazine.hasWord("Bleegh"));
		assertFalse(testMagazine.hasWord("bleegh"));
		assertTrue(testMagazine.hasWord("Bleugh"));
		assertFalse(testMagazine.hasWord("yepee"));
		assertTrue(testMagazine.hasWord("aaasavad"));
		assertFalse(testMagazine.hasWord("zinger"));
		assertTrue(testMagazine.hasWord("blarg"));
		assertFalse(testMagazine.hasWord("Blarg"));
		
		assertEquals(2, testMagazine.getCount("yep"));
		assertEquals(1, testMagazine.getCount("blarg"));
	}
	
	@Test
	public void testRemoveWord() {
		String testWord = "Bleegh";
		testMagazine.removeWord(testWord);
		assertFalse(testMagazine.hasWord(testWord));
		
		testWord = "yep";
		testMagazine.removeWord(testWord);
		assertTrue(testMagazine.hasWord(testWord));
		assertEquals(1, testMagazine.getCount(testWord));
	}

}
