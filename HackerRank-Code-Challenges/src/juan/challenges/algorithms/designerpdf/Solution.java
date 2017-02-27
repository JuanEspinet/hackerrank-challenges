package juan.challenges.algorithms.designerpdf;

import java.util.Scanner;

/**
 * Solution to hackerrank challenge from: https://www.hackerrank.com/challenges/designer-pdf-viewer
 * 
 * @author juanespinet
 *
 */
public class Solution {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] h = new int[26];
        for(int h_i=0; h_i < 26; h_i++){
            h[h_i] = in.nextInt();
        }
        String word = in.next();
        System.out.println(getWordArea(word, h));
    }
	
	/**
	 * Gets the height of a given character based on a set of provided heights.
	 * 
	 * @param c Character
	 * @param heights Letter heights
	 * @return Integer height.
	 */
	public static int getHeight(char c, int[] heights) {
		return heights[c - 'a'];
	}
	
	/**
	 * Gets the height of the highest letter in a word,
	 * given a list of letter heights.
	 * 
	 * @param word
	 * @param heights Letter heights.
	 * @return Max height as int.
	 */
	public static int getMaxHeight(String word, int[] heights) {
		int maxHeight = 0;
		
		for (int i = 0; i < word.length(); i++) {
			int height = getHeight(word.charAt(i), heights);
			if (height > maxHeight) {
				maxHeight = height;
			}
		}
		
		return maxHeight;
	}
	
	/**
	 * Gets the area of a word selection rectangle based on a
	 * list of given character heights.
	 * 
	 * @param word
	 * @param heights
	 * @return Word area as int.
	 */
	public static int getWordArea(String word, int[] heights) {
		return getMaxHeight(word, heights) * word.length();
	}
}
