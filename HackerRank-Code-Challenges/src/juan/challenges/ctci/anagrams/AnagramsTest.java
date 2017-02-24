package juan.challenges.ctci.anagrams;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class AnagramsTest {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testNumberNeeded() {
		int num = Anagrams.numberNeeded("abc", "aba");
		assertEquals(2, num);
		
		num = Anagrams.numberNeeded("abc", "abcd");
		assertEquals(1, num);
		
		num = Anagrams.numberNeeded("abc", "abcdiweuriwje");
		assertEquals(10, num);
		
		num = Anagrams.numberNeeded("abch", "cdbjnwoeurena");
		assertEquals(11, num);
	}
	
	@Test
	public void testGetIndex() {
		int index = Anagrams.getIndex('a');
		assertEquals(0, index);
		
		index = Anagrams.getIndex('b');
		assertEquals(1, index);
	}
	
	@Test
	public void testCompareFrequencies() {
		int[] freqs = Anagrams.compareFrequencies(null, "aaabbccd");
		assertEquals(3, freqs[0]);
		assertEquals(2, freqs[1]);
		assertEquals(2, freqs[2]);
		assertEquals(1, freqs[3]);
		
		freqs = Anagrams.compareFrequencies(null, "dababbccesqd");
		assertEquals(2, freqs[0]);
		assertEquals(3, freqs[1]);
		assertEquals(2, freqs[2]);
		assertEquals(2, freqs[3]);
		assertEquals(0, freqs[5]);

		int[] compared = Anagrams.compareFrequencies(freqs, "aafg");
		assertEquals(2, freqs[0]);
		assertEquals(0, compared[0]);
		assertEquals(3, compared[1]);
		assertEquals(2, compared[2]);
		assertEquals(2, compared[3]);
		assertEquals(1, compared[5]);
		assertEquals(1, compared[6]);
	}
	
	@Test
	public void sumArray() {
		int differences = Anagrams.sumArray(new int[]{0,2,3,2,0});
		assertEquals(7, differences);
	}

}
