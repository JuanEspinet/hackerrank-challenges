package juan.challenges.ctci.anagrams;

import java.util.Arrays;
import java.util.Scanner;

/**
 * My solution to a code challenge from hackerrank.com, 
 * description at https://www.hackerrank.com/challenges/ctci-making-anagrams
 * 
 * @author juanespinet
 *
 */
public class Anagrams {
	/**
	 * Compares to strings and returns the number
	 * of deletions needed total to make the two strings
	 * anagrams.
	 * 
	 * @param String first
	 * @param String second
	 * @return int The number of deletions needed.
	 */
	public static int numberNeeded(String first, String second) {
		// get frequencies for first string
		int[] difference = compareFrequencies(null, first);
		// compare to second string
		difference = compareFrequencies(difference, second);
		// calculate total deletions
		return sumArray(difference);
	}
	
	/**
	 * Returns the index position in a 26 item
	 * array for an entry corresponding to a 
	 * lowercase english character.
	 * 
	 * @param c The character for which an index is needed
	 * @return int The index that character is a key for
	 */
	public static int getIndex(char c) {
		/*
		 * Since we are only expecting lowercase english
		 * characters, our array will be indexed with a
		 * as zero.
		 */
		return (int) c - 'a';
	}
	
	/**
	 * Compares the frequences of characters
	 * from a previously analyzed string to the
	 * given string and returns a new array
	 * representing the differences between the two.
	 * Array indices are calculated using the
	 * character values, assuming that inputs chars
	 * can only be lowercase english letters.
	 * If frequencies parameter is null, the string
	 * result will be the differences between the
	 * given string and an empty string.
	 * 
	 * @param frequencies The frequencies to compare to
	 * @param word The string to analyze
	 * @return int[] An array 
	 */
	public static int[] compareFrequencies(int[] frequencies, String word) {
		// check if a frequency array was passed
		if (frequencies == null) {
			// initialize an empty array to compare
			frequencies = new int[26];
		} else {
			// avoid modifying the original array in place
			frequencies = Arrays.copyOf(frequencies, frequencies.length);
		}
		
		// loop over word
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			int index = getIndex(c);
			// calculate differences by subtraction
			frequencies[index]--;
		}
		
		// change values to positive to represent difference
		for (int i = 0; i < frequencies.length; i++) {
			frequencies[i] = Math.abs(frequencies[i]);
		}
		
		return frequencies;
	}
	
	public static int sumArray(int[] diffs) {
		int diffTotal = 0;
		for (int diff : diffs) {
			diffTotal += diff;
		}
		return diffTotal;
	}
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
        in.close();
    }
}
