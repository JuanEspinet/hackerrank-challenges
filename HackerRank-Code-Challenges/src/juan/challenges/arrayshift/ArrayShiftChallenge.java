package juan.challenges.arrayshift;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import org.omg.CORBA.Current;

/**
 * Challenge solution for challenge described at https://www.hackerrank.com/challenges/ctci-array-left-rotation
 *
 */
public class ArrayShiftChallenge {

	public static void main(String[] args) {
		ArrayShiftChallenge instance = new ArrayShiftChallenge();
		
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        
        printArray(instance.rotateArray(a, k));
    }
    
    public int[] rotateArray(int[] arrayToRotate, int positions) {
    	int currentIndex = 0;
    	int current = arrayToRotate[0];
        int shiftAfter = 0;
    	int shiftCounter = 0;
    	positions %= arrayToRotate.length;
    	
    	if (positions == 0)
    		return arrayToRotate;
        
        if (arrayToRotate.length % positions == 0) {
    		shiftAfter = arrayToRotate.length/positions;
    	}
    	
    	for (int i = 0; i < arrayToRotate.length; i++) {
    		int nextIndex = (currentIndex - positions + arrayToRotate.length) % arrayToRotate.length;
    		
    		int next = arrayToRotate[nextIndex];
    		
    		arrayToRotate[nextIndex] = current;
    		current = next;
    		currentIndex = nextIndex;
    		
    		if (shiftAfter > 0 && ++shiftCounter == shiftAfter) {
    			currentIndex++;
    			current = arrayToRotate[currentIndex];
    			shiftCounter = 0;
    		}
    	}

    	return arrayToRotate;
    }
    
    public static void printArray(int[] toPrint) {
        for (int i = 0; i < toPrint.length; i++) {
        	System.out.print(toPrint[i]);
        	
        	if (i < toPrint.length - 1) 
        		System.out.print(" ");
        }		
    }
}
