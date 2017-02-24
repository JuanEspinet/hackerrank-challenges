package juan.challenges.queuesstacks;

import static org.junit.Assert.*;

import java.util.Random;
import java.util.Stack;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;

public class MyQueueTest {

	public MyQueue<Integer> testQueue;
	public Random rand = new Random();
	
	@Before
	public void setUp() throws Exception {
		testQueue = new MyQueue<Integer>();
		testQueue.inStack.push(1);
		testQueue.outStack.push(2);
	}

	@Test
	public void testConstructor() {
		assertThat(testQueue.inStack, isA(Stack.class));
		assertThat(testQueue.outStack, isA(Stack.class));
		
		assertThat(testQueue.inStack.peek(), isA(Integer.class));
		assertThat(testQueue.outStack.peek(), isA(Integer.class));
	}

	@Test
	public void testEnqueue() {
		testQueue.enqueue(1);
		
		assertEquals(2, testQueue.inStack.size());
		
		for (int i = 0; i < 100; i++) {
			testQueue.enqueue(rand.nextInt(10000));
		}
		
		assertEquals(102, testQueue.inStack.size());
	}
	
	@Test
	public void testDequeue() {
		testQueue.dequeue();
		
		assertEquals(1, testQueue.inStack.size());
		assertEquals(0, testQueue.outStack.size());
		
		testQueue.dequeue();
		
		assertEquals(0, testQueue.inStack.size());
		assertEquals(0, testQueue.outStack.size());
	}
	
	@Test
	public void testPeek() {
		assertThat(testQueue.peek(), isA(Integer.class));
		assertEquals(2, (int) testQueue.peek());
		
		testQueue.outStack.pop();
		
		assertThat(testQueue.peek(), isA(Integer.class));
		assertEquals(1, (int) testQueue.peek());
		
		testQueue.outStack.pop();
	}
	
	@Test
	public void testRefillOut() {
		testQueue.refillOutIfEmpty();
		
		assertEquals(1, testQueue.inStack.size());
		assertEquals(1, testQueue.outStack.size());
		
		testQueue.outStack.pop();
		testQueue.refillOutIfEmpty();
		
		assertEquals(0, testQueue.inStack.size());
		assertEquals(1, testQueue.outStack.size());
		
		testQueue.outStack.pop();
		for (int i = 0; i < 100; i++) {
			testQueue.inStack.push(rand.nextInt(10000));
		}
		testQueue.refillOutIfEmpty();
		
		assertEquals(0, testQueue.inStack.size());
		assertEquals(100, testQueue.outStack.size());
	}
}
