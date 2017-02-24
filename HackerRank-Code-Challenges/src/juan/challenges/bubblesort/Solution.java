package juan.challenges.bubblesort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Solution to bubble sort swap counting challenge from: https://www.hackerrank.com/challenges/ctci-bubble-sort
 * 
 * Bubble sort algorithm provided by challenge description and modified to optimize and allow counting total swaps.
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
        
        int totalSwaps = 0;
        
        for (int i = 0; i < n; i++) {
            // Track number of elements swapped during a single array traversal
            int numberOfSwaps = 0;
            
            for (int j = 0; j < n - i - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    swap(j, j + 1, a);
                    numberOfSwaps++;
                }
            }
            
            // If no elements were swapped during a traversal, array is sorted
            if (numberOfSwaps == 0) {
                break;
            }
            
            totalSwaps += numberOfSwaps;
        }
        
        printResult(a, totalSwaps);
    }

    /**
     * Swaps the values at the given two indices in an array.
     * 
     * @param index1
     * @param index2
     * @param array
     */
	public static void swap(int index1, int index2, int[] array) {
		int val1 = array[index1];
		int val2 = array[index2];
		array[index1] = val2;
		array[index2] = val1;
	}
	
	/**
	 * Prints the results of a sort in the format required by this challenge.
	 * 
	 * @param array
	 * @param swaps
	 */
	public static void printResult(int[] array, int swaps) {
		System.out.println(String.format("Array is sorted in %d swaps.", swaps));
		System.out.println(String.format("First Element: %d", array[0]));
		System.out.println(String.format("Last Element: %d", array[array.length - 1]));
	}
    
    
}
