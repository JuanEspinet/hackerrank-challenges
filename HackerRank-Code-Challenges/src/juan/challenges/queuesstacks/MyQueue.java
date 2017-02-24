package juan.challenges.queuesstacks;

import java.util.Stack;

public class MyQueue<T> {
	
	protected Stack<T> inStack;
	protected Stack<T> outStack;

	public MyQueue() {
		this.inStack = new Stack<T>();
		this.outStack = new Stack<T>();
	}

	public void enqueue(T next) {
		// TODO Auto-generated method stub
		
	}

	public void dequeue() {
		// TODO Auto-generated method stub
		
	}

	public T peek() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Checks if the out stack is empty
	 * and refills from the in stack if so.
	 */
	protected void refillOut() {
		
	}

}
