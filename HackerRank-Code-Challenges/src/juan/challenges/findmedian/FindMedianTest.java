package juan.challenges.findmedian;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

public class FindMedianTest {
	
	Balancer balancer;

	@Before
	public void setUp() throws Exception {
		this.balancer = new Balancer();
	}
	
	@Test
	public void testGetMedian() {
		balancer.leftQueue.offer(1);
		
		double median = balancer.getMedian();
		
		balancer.rightQueue.offer(2);
		
		double median2 = balancer.getMedian();
		
		balancer.leftQueue.offer(0);
		
		double median3 = balancer.getMedian();
		
		assertEquals(1d, median, 0.01d);
		assertEquals(1.5d, median2, 0.01d);
		assertEquals(1.0d, median3, 0.01d);
		
	}

	@Test
	public void testQueuesBalanced() {
		balancer.leftQueue.offer(1);
		balancer.rightQueue.offer(2);
		boolean bad;
		boolean good = balancer.queuesBalanced();
		balancer.rightQueue.offer(4);
		balancer.rightQueue.offer(5);
		bad = balancer.queuesBalanced();
		
		assertTrue(good);
		assertFalse(bad);
		
		balancer.leftQueue.offer(0);
		good = balancer.queuesBalanced();
		
		assertTrue(good);
	}
	
	@Test
	public void testBalanceQueues() {
		balancer.leftQueue.offer(1);
		balancer.rightQueue.offer(2);
		balancer.balanceQueues();
		assertEquals(2, (int) balancer.rightQueue.peek());
		assertTrue(balancer.leftQueue.size() == balancer.rightQueue.size());
		
		balancer.rightQueue.offer(5);
		balancer.rightQueue.offer(4);
		balancer.rightQueue.offer(3);
		balancer.balanceQueues();
		
		assertEquals(3, (int) balancer.rightQueue.peek());
		
		balancer.rightQueue.offer(7);
		balancer.rightQueue.offer(8);
		balancer.rightQueue.offer(9);
		balancer.balanceQueues();
		
		assertEquals(4, (int) balancer.leftQueue.peek());
		assertEquals(5, (int) balancer.rightQueue.peek());
		assertTrue(balancer.leftQueue.size() == balancer.rightQueue.size());
	}
	
	@Test
	public void testAddNumber() {
		balancer.addNumber(1);
		
		assertEquals(1, (int) balancer.leftQueue.peek());
		assertNull(balancer.rightQueue.peek());
		
		balancer.addNumber(2);
		
		assertEquals(1, (int) balancer.leftQueue.peek());
		assertEquals(2, (int) balancer.rightQueue.peek());
		
		balancer.addNumber(3);
		
		assertEquals(1, (int) balancer.leftQueue.peek());
		assertEquals(2, (int) balancer.rightQueue.peek());
		
		balancer.addNumber(4);
		
		assertEquals(2, (int) balancer.leftQueue.peek());
		assertEquals(3, (int) balancer.rightQueue.peek());
	}
	
	@Test
	public void testGetLargerQueue() {
		assertNull(balancer.getLargerQueue());
		
		balancer.leftQueue.offer(1);
		balancer.rightQueue.offer(2);
		balancer.leftQueue.offer(0);
		assertEquals(balancer.leftQueue, balancer.getLargerQueue());
		
		balancer.rightQueue.offer(5);
		balancer.rightQueue.offer(7);
		assertEquals(balancer.rightQueue, balancer.getLargerQueue());
	}

}
