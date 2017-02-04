package juan.challenges.bfsshortestreach;

import static org.junit.Assert.*;

import java.util.Iterator;

import static org.hamcrest.CoreMatchers.instanceOf;

import org.junit.Before;
import org.junit.Test;

public class VertexTest {
	
	Vertex testVertex;

	@Before
	public void setUp() throws Exception {
		testVertex = new Vertex(1);
		testVertex.setEdegeTo(2);
	}

	@Test
	public void testGetVertexNumber() {
		assertEquals(1, testVertex.getVertexNumber());
	}
	
	@Test
	public void testIsAdjacent() {
		assertFalse(testVertex.adjacentTo(5));
		assertTrue(testVertex.adjacentTo(2));
	}

	@Test
	public void testSetEdgeTo() {
		assertFalse(testVertex.adjacentTo(5));
		testVertex.setEdegeTo(5);
		assertTrue(testVertex.adjacentTo(5));
	}
	
	@Test
	public void testGetEdgeArray() {
		Iterator<Integer> edgeIterator = testVertex.getEdgeIterator();
		
		assertTrue(edgeIterator.hasNext());
		
		Integer edge = edgeIterator.next();
		
		assertThat(edge, instanceOf(Integer.class));
		
		assertEquals(2, (int) edge);
	}
}
