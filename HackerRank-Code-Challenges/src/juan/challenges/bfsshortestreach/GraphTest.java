package juan.challenges.bfsshortestreach;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;

import org.junit.Before;
import org.junit.Test;

public class GraphTest {

	Graph testGraph;
	
	@Before
	public void setUp() throws Exception {
		testGraph = new Graph(4);
	}
	
	@Test
	public void testGetVertex() {
		Vertex testVertex = testGraph.getVertex(1);
		assertThat(testVertex, instanceOf(Vertex.class));
		assertEquals(1, testVertex.getVertexNumber());
	}

	@Test
	public void testSetEdge() {
		Vertex testVertex = testGraph.getVertex(1);
		Vertex testVertex2 = testGraph.getVertex(2);
		testGraph.setEdge(1, 2);
		
		assertTrue(testVertex.adjacentTo(2));
		assertTrue(testVertex2.adjacentTo(1));
		
		assertEquals(1, testVertex.edgeCount());
		assertEquals(1, testVertex2.edgeCount());
	}

	@Test
	public void testFindMinDistance() {
		testGraph.setEdge(1, 2);
		testGraph.setEdge(2, 3);
		
		assertEquals(-1, testGraph.findMinDistance(1, 4));
		assertEquals(6, testGraph.findMinDistance(1, 2));
		assertEquals(12, testGraph.findMinDistance(1, 3));
	}
	
	@Test
	public void testFindAllDistances() {
		int[] testResults = testGraph.findAllDistances(1);
		
		assertEquals(5, testResults.length);
		
		for (int i = 0; i < testResults.length; i++) {
			assertEquals(-1, testResults[i]);
		}
		
		testGraph.setEdge(1, 2);
		testGraph.setEdge(2, 3);
		
		testResults = testGraph.findAllDistances(1);
		
		assertEquals(-1, testResults[0]);
		assertEquals(-1, testResults[1]);
		assertEquals(6, testResults[2]);
		assertEquals(12, testResults[3]);
		assertEquals(-1, testResults[4]);
	}
}
