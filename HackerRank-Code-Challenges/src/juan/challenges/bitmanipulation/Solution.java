package juan.challenges.bitmanipulation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Solution to a coding challenge from HackerRank.com
 * Challenge description can be found at: https://www.hackerrank.com/challenges/ctci-lonely-integer
 * 
 * 
 * @author juanespinet
 *
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        
        System.out.println(findLonelyByBit(a));
        
        in.close();
    }
    
    /**
     * Solution with bit manipulation.
     * 
     */
    public static int findLonelyByBit(int[] ints) {
    	int result = ints[0];
    	
    	for (int i = 1; i < ints.length; i++) {
			result = result ^ ints[i];
		}
    	
    	return result;
    }
    
    /**
     * Solution without bit manipulation.
     * 
     * @param intsToScan
     * @return
     */
    public static int findLonley(int[] intsToScan) {
    	Arrays.sort(intsToScan);
    	
    	for (int i = 0; i < intsToScan.length; i += 2) {
			if (i == intsToScan.length - 1 
					|| intsToScan[i] != intsToScan[i + 1]) {
				return intsToScan[i];
			}
		}
    	
    	return -1;
    }
}
