package juan.challenges.ctci.ransomnote;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NoteTest {

	Magazine testMagazine;
	Note testNote;
	
	@Before
	public void setUp() throws Exception {
		String[] words = {"Bleegh", "Bleugh", "blarg", "yep", "aaasavad", "yep"};
		testMagazine = new Magazine(words);
	}

	@Test
	public void testFailBuildNote() {
		String[] noteWords = {"Bleegh", "blarg", "fin"};
		testNote = new Note(noteWords);
		
		assertFalse(testNote.buildNote(testMagazine));
	}
	
	@Test
	public void testSucceedBuildNote() {
		String[] noteWords2 = {"Bleegh", "yep", "aaasavad"};
		testNote = new Note(noteWords2);
		
		assertTrue(testNote.buildNote(testMagazine));
	}

}
