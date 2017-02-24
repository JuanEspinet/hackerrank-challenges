package juan.challenges.ctci.bfsshortestreach;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	Graph testGraph;
	
	@Before
	public void setUp() throws Exception {
		testGraph = new Graph(5);
		testGraph.setEdge(1, 2);
		testGraph.setEdge(2, 3);
		testGraph.setEdge(3, 4);
		testGraph.setEdge(1, 4);
	}

	@Test
	public void testGetDistanceString() {
		String distanceString = Solution.getDistanceString(1, testGraph);
		
		assertTrue(distanceString.equals("6 12 6 -1"));
	}

}
