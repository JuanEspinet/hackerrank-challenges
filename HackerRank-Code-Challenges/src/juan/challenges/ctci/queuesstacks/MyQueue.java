package juan.challenges.ctci.queuesstacks;

import java.util.EmptyStackException;
import java.util.Stack;

public class MyQueue<T> {
	
	protected Stack<T> inStack;
	protected Stack<T> outStack;

	public MyQueue() {
		this.inStack = new Stack<T>();
		this.outStack = new Stack<T>();
	}

	/**
	 * Adds an item to the end of the queue;
	 * 
	 * @param next
	 */
	public void enqueue(T next) {
		this.inStack.push(next);
	}

	/**
	 * Removes the item from the head of the queue;
	 */
	public void dequeue() {
		// check if out is empty and refill if so
		refillOutIfEmpty();
		// remove the last item from the out stack
		try {
			this.outStack.pop();
		} catch (EmptyStackException e) {
			// do nothing
		}
	}

	public T peek() {
		// check if out is empty and refill if so
		refillOutIfEmpty();
		// attempt to look at the first item
		try {
			return this.outStack.peek();
		} catch (EmptyStackException e) {
			return null;
		}
	}
	
	/**
	 * Checks if the out stack is empty
	 * and refills from the in stack if so.
	 */
	protected void refillOutIfEmpty() {
		if (this.outStack.empty()) {
			while (!this.inStack.empty()) {
				this.outStack.push(this.inStack.pop());
			}
		}
	}
}
