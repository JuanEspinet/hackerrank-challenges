package juan.challenges.algorithms.appleandorange;

import java.util.Scanner;

/**
 * Solution to HackerRank challenge found at: https://www.hackerrank.com/challenges/apple-and-orange
 * 
 * @author juanespinet
 *
 */
public class Solution {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int[] apple = new int[m];
        for(int apple_i=0; apple_i < m; apple_i++){
            apple[apple_i] = in.nextInt();
        }
        int[] orange = new int[n];
        for(int orange_i=0; orange_i < n; orange_i++){
            orange[orange_i] = in.nextInt();
        }
    }
}
