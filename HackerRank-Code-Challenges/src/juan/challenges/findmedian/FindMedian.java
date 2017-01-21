package juan.challenges.findmedian;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Challenge from: https://www.hackerrank.com/challenges/ctci-find-the-running-median
 * 
 * @author juanespinet
 *
 */
public class FindMedian {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Balancer balancer = new Balancer();
        int n = in.nextInt();
        int[] a = new int[n];
        
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        
        for (int i = 0; i < a.length; i++) {
			balancer.addNumber(a[i]);
			System.out.println(balancer.getMedian());
		}
        
        in.close();
    }
}

/**
 * Creates two balanced priority queues (heaps)
 * and keeps them balanced as numbers are added.
 * Contains methods for calculating the current
 * median of the stored set of numbers.
 * 
 * @author juanespinet
 *
 */
class Balancer {
	PriorityQueue<Integer> leftQueue;
	PriorityQueue<Integer> rightQueue;
	double median;
	
	public Balancer() {
		leftQueue = new PriorityQueue<Integer>(10000, Collections.reverseOrder());
		rightQueue = new PriorityQueue<Integer>(10000);
		median = 0.0d;
	}
	
	/**
	 * Compares the head values of the two priority
	 * queues and their sizes, and determines a median.
	 * 
	 * @return
	 */
	public double getMedian() {
		// check if one queue is larger than the other
		PriorityQueue<Integer> larger = this.getLargerQueue();
		
		if (larger == null) {
			// queues the same size, median is between the two heads
			return (double) (leftQueue.peek() + rightQueue.peek()) / 2;
		}
		
		// queues different sizes, the head of the larger queue is the median
		return (double) larger.peek();
	}
	
	public boolean queuesBalanced() {
		return Math.abs(leftQueue.size() - rightQueue.size()) <= 1;
	}
	
	/**
	 * Moves from the head of the larger queue
	 * to the smaller, until the two queues
	 * are balanced in size (difference <= 1)
	 */
	public void balanceQueues() {
		PriorityQueue<Integer> larger = getLargerQueue();
		PriorityQueue<Integer> smaller = getSmallerQueue();
		
		while (!queuesBalanced()) {
			smaller.offer(larger.poll());
		}
	}

	/**
	 * Adds an integer to the right or left
	 * queue depending on its size, then balances
	 * the two queues so the current median is
	 * correct.
	 * 
	 * @param num
	 */
	public void addNumber(int num) {
		if (leftQueue.isEmpty() 
				|| num < leftQueue.peek()) {
			leftQueue.offer(num);
		} else {
			rightQueue.offer(num);
		}
		
		balanceQueues();
	}
	
	/**
	 * Compares the size of the right and left
	 * queues and returns the larger.
	 * 
	 * @return The larger PriorityQueue
	 */
	public PriorityQueue<Integer> getLargerQueue() {
		if (leftQueue.size() == rightQueue.size()) {
			return null;
		} else if (leftQueue.size() > rightQueue.size()) {
			return leftQueue;
		} else {
			return rightQueue;
		}
	}
	
	/**
	 * Compares the size of the right and left
	 * queues and returns the smaller.
	 * 
	 * @return The smaller PriorityQueue
	 */
	public PriorityQueue<Integer> getSmallerQueue() {
		if (leftQueue.size() == rightQueue.size()) {
			return null;
		} else if (leftQueue.size() < rightQueue.size()) {
			return leftQueue;
		} else {
			return rightQueue;
		}
	}
	
	public void addAndPrintMedian(int num) {
		this.addNumber(num);
		System.out.println(this.getMedian());
	}
}
