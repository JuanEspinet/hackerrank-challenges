package juan.challenges.countinversions;

import java.lang.reflect.Array;
import java.util.Arrays;
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
    	// check to make sure we have been passed a temp array
    	// using one temp array for all recursive calls reduces memory complexity
    	int size = rightEnd - leftStart + 1;
    	if (tempArray == null) tempArray = new int[size];
    	
    	// find the right starting point
    	int mid = (leftStart + rightEnd) / 2;
    	int leftPointer = leftStart;
    	int rightPointer = mid + 1;
    	
    	// set the starting point at the temp array
    	int tempIndex = leftStart;
    	
    	// compare the two halves
    	while (leftPointer <= mid && rightPointer <= rightEnd) {
    		
			if (array[leftPointer] < array[rightPointer]) {
				tempArray[tempIndex] = array[leftPointer];
				leftPointer++;
			} else {
				tempArray[tempIndex] = array[rightPointer];
				rightPointer++;
			}
			
			tempIndex++;
		}
    	
    	// add any remaining from each half
    	while (leftPointer <= mid) {
    		tempArray[tempIndex] = array[leftPointer];
			leftPointer++;
			tempIndex++;
    	}
    	while (rightPointer <= rightEnd) {
    		tempArray[tempIndex] = array[rightPointer];
			rightPointer++;
			tempIndex++;
    	}
    	
    	// move the temporary array into the correct section of the original array
    	System.arraycopy(tempArray, leftStart, array, leftStart, size);
    }
}
