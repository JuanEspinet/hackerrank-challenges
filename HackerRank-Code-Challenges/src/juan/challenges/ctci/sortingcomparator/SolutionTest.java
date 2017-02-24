package juan.challenges.ctci.sortingcomparator;

import static org.junit.Assert.*;

import org.hamcrest.core.Is;

import static org.hamcrest.number.OrderingComparison.*;

import org.junit.Before;
import org.junit.Test;


public class SolutionTest {

	Checker checker;
	Player player1;
	Player player2;
	Player player3;
	Player player4;
	Player player5;
	
	@Before
	public void setUp() throws Exception {
		checker = new Checker();
		player1 = new Player("Aaron", 5);
		player2 = new Player("Aaron", 6);
		player3 = new Player("Bob", 5);
		player4 = new Player("Alan", 6);
		player5 = new Player("Aarona", 4);
	}

	@Test
	public void testCompare() {
		// 6 before 5, names equal
		assertThat(checker.compare(player1, player2), greaterThan(0));
		assertThat(checker.compare(player2, player1), lessThan(0));
		
		// 'Aaron' before 'Bob', scores equal
		assertThat(checker.compare(player1, player3), lessThan(0));
		
		// 6 before 5, names ignored
		assertThat(checker.compare(player1, player4), greaterThan(0));
		
		// 'Aaron' before 'Alan', scores equal
		assertThat(checker.compare(player2, player4), lessThan(0));
		assertThat(checker.compare(player4, player2), greaterThan(0));
		
		// 6 before 5, names ignored
		assertThat(checker.compare(player3, player2), greaterThan(0));
	}
	
	@Test
	public void testCompareAlpha() {
		// 'Aaron' and 'Aaron' equal
		assertEquals(0, checker.compareAlpha(player1, player2));
		
		// 'Aaron' before 'Bob'
		assertThat(checker.compareAlpha(player1, player3), lessThan(0));
		
		// 'Aaron' before 'Alan'
		assertThat(checker.compareAlpha(player1, player4), lessThan(0));
		
		// 'Alan' before 'Bob'
		assertThat(checker.compareAlpha(player4, player3), lessThan(0));
		
		// 'Aaron' before 'Aarona'
		assertThat(checker.compareAlpha(player1, player5), lessThan(0));
	}

}
