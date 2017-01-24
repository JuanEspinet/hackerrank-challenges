package juan.challenges.dpcoin;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CointTest {

	CoinChanger changer;
	
	@Before
	public void setUp() throws Exception {
		Integer[] coins = {2,5,3,6};
		this.changer = new CoinChanger(coins, 10);
	}

	@Test
	public void testGetFromIndex() {
		long oneSolution = this.changer.getFromIndex(0, 10);
		assertEquals(1, oneSolution);
		
		long twoSolutions = this.changer.getFromIndex(1, 6);
		assertEquals(2, twoSolutions);
		
		long fiveSolutions = this.changer.getFromIndex(3, 10);
		assertEquals(5, fiveSolutions);
	}
	
	@Test
	public void testGetCombinations() {
		long five = this.changer.getCombinations();
		assertEquals(5, five);
	}

}
