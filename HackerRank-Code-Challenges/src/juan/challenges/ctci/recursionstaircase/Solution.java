package juan.challenges.ctci.recursionstaircase;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Solution to hackerrank challenge on recursion:
 * 
 * Challenge description at: https://www.hackerrank.com/challenges/ctci-recursive-staircase
 * 
 * @author juanespinet
 *
 */
public class Solution {

	/**
	 * Finds the total number of ways a staircase
	 * of a given size can be climbed in some
	 * combination of 1, 2, and 3 steps at a time.
	 * 
	 * Uses a HashMap of solutions to decrease time
	 * complexity by eliminating redundant calculations.
	 * 
	 * @param steps
	 * @param found HashMap to track already found solutions
	 * @return Int number of ways
	 */
	public static long findWaysUp(int steps, HashMap<Integer, Long> found) {
		if (steps == 0) return 1;
		if (steps < 0) return 0;
		
		if (found == null) found = new HashMap<Integer, Long>();
		
		if (found.containsKey(steps)) return (long) found.get(steps);
		
		long result = findWaysUp(steps - 1, found) 
				+ findWaysUp(steps - 2, found) 
				+ findWaysUp(steps - 3, found);
		
		found.put(steps, result);
		
		return result;
	}
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for(int a0 = 0; a0 < s; a0++){
            int n = in.nextInt();
            System.out.println(findWaysUp(n, null));
        }
    }
}