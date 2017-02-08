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
        
        MergeShiftCounter counter = new MergeShiftCounter();
        
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int arr_i=0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            System.out.println(counter.countShifts(arr));
        }
    }
}

/**
 * Performs merge sort and counts the number of shifts required
 * for that merge.
 * 
 * @author juanespinet
 *
 */
class MergeShiftCounter {
	long shifts = 0;
	
	/**
	 * Performs a merge sort on an entire array
	 * and returns the total number of shifts required
	 * to perform this sort.
	 * 
	 * @param array
	 */
	public long countShifts(int[] array) {
		// reset the shifts counter
		shifts = 0;
		
		// run the sort, which internally increments this counter
		this.mergeSort(array, 0, array.length - 1, null);
		
		return shifts;
	}
	
	/**
	 * Performs a merge sort on the given array segment and counts
	 * the total number of shifts used in this sort.
	 * 
	 * @param array
	 * @param leftStart
	 * @param rightEnd
	 * @param tempArray
	 */
	public void mergeSort(int[] array, int leftStart, int rightEnd, int[] tempArray) {
		if (leftStart < rightEnd) {
			// check to make sure we have been passed a temp array
	    	// using one temp array for all recursive calls reduces memory complexity
	    	int size = rightEnd - leftStart + 1;
	    	if (tempArray == null) tempArray = new int[size];
	    	
	    	// find the midpoint
	    	int mid = (leftStart + rightEnd) / 2;
	    	
	    	// divide into two halves and sort them
	    	mergeSort(array, leftStart, mid, tempArray);
	    	mergeSort(array, mid + 1, rightEnd, tempArray);
	    	
	    	// merge the sorted halves
	    	mergeArraySections(array, leftStart, rightEnd, tempArray);
		}
	}
	
	/**
	 * Merges two sections of an array and counts the number
	 * of shifts that were required for each element.
	 * 
	 * @param array
	 * @param leftStart
	 * @param rightEnd
	 * @param tempArray
	 */
	public void mergeArraySections(int[] array, int leftStart, int rightEnd, int[] tempArray) {
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
    		
			if (array[leftPointer] <= array[rightPointer]) {
				tempArray[tempIndex] = array[leftPointer];
				leftPointer++;
			} else {
				tempArray[tempIndex] = array[rightPointer];
				// increment the total count of left shifts performed
				this.shifts += rightPointer - tempIndex;
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
