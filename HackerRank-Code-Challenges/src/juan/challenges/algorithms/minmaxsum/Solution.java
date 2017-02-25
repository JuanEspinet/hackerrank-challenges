package juan.challenges.algorithms.minmaxsum;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Solution to challenge from https://www.hackerrank.com/challenges/mini-max-sum
 * 
 * 
 * @author juanespinet
 *
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        long[] a = new long[5];
        
        for (int i = 0; i < 5; i++) {
			a[i] = in.nextLong();
		}
        
        PriorityQueue<Long> maxList = new PriorityQueue<Long>(4);
        PriorityQueue<Long> minList = new PriorityQueue<Long>(4, Collections.reverseOrder());
        
        for (int i = 0; i < a.length; i++) {
        	// maintain a running list of the four biggest numbers encountered
			if (maxList.size() < 4) {
				maxList.offer(a[i]);
			} else if (maxList.peek() < a[i]) {
				maxList.remove();
				maxList.offer(a[i]);
			}
			
			// maintain a running list of the four smallest numbers encountered
			if (minList.size() < 4) {
				minList.offer(a[i]);
			} else if (minList.peek() > a[i]) {
				minList.remove();
				minList.offer(a[i]);
			}
		}
        
        // calculate out the min and max sums
        long maxSum = 0;
        long minSum = 0;
        
        while (!maxList.isEmpty()) {
			maxSum += maxList.poll();
		}
        
        while (!minList.isEmpty()) {
			minSum += minList.poll();
		}
        
        System.out.println(minSum + " " + maxSum);
        
        in.close();
	}
}
