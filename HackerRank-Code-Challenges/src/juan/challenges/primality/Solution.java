package juan.challenges.primality;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Solution to HackerRank challenge for finding primes.
 * 
 * Challenge description at: https://www.hackerrank.com/challenges/ctci-big-o
 * 
 * @author juanespinet
 *
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        for(int a0 = 0; a0 < p; a0++){
            int n = in.nextInt();
            if (isPrime(n)) {
				System.out.println("Prime");
			} else {
				System.out.println("Not prime");
			}
        }
    }
    
    public static boolean isPrime(int num) {
    	// we don't need to search higher than the square root of the tested number
    	double squareRoot = Math.sqrt(num);
    	
    	// primes are never even or less than 2
    	if (num != 2 
    			&& (num % 2 == 0
    			|| num < 2 
    			|| num % Math.round(squareRoot) == 0)) {
    		return false;
    	}
    	
    	// check all odd numbers smaller than the square root
    	for (int i = 3; i < squareRoot; i += 2) {
			if (num % i == 0) {
				return false;
			}
		}
    	
    	return true;
    }
}
