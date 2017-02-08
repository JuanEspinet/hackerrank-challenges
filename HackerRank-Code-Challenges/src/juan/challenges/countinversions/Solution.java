package juan.challenges.countinversions;

import java.lang.reflect.Array;
import java.util.Scanner;

/**
 * Solution to inversion counting challenge from HackerRank.com.
 * 
 * Challenge description at: https://www.hackerrank.com/challenges/ctci-merge-sort
 * 
 * 
 * @author juanespinet
 *
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int arr_i=0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
        }
    }
    
    public static void mergeArraySections(int[] array, int leftStart, int rightEnd, int[] tempArray) {
    	
    }
}
