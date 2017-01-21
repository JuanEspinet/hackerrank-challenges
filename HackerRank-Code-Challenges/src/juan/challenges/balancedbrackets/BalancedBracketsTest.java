package juan.challenges.balancedbrackets;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BalancedBracketsTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testIsBalanced() {
		boolean good = BalancedBrackets.isBalanced("{}");
		boolean bad = BalancedBrackets.isBalanced("{[(])}");
		boolean good2 = BalancedBrackets.isBalanced("{{{[[[(({{}}))]]]}}}");
		boolean bad2 = BalancedBrackets.isBalanced("{{{[[[(({{}}))]]]}}");
		boolean bad3 = BalancedBrackets.isBalanced("{{{[[[(({{}}))]]]}}}}");
		
		assertTrue(good);
		assertFalse(bad);
		assertTrue(good2);
		assertFalse(bad2);
		assertFalse(bad3);
	}

	@Test
	public void testGetMatchingClose() {
		Character square = BalancedBrackets.getMatchingClose('[');
		Character curl = BalancedBrackets.getMatchingClose('{');
		Character paren = BalancedBrackets.getMatchingClose('(');
		Character wrong = BalancedBrackets.getMatchingClose('}');
		
		assertEquals(']', (char) square);
		assertEquals('}', (char) curl);
		assertEquals(')', (char) paren);
		assertTrue(wrong == null);
	}

}
