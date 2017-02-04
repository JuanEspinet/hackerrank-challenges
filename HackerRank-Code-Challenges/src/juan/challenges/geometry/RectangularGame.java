package juan.challenges.geometry;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Challenge description at https://www.hackerrank.com/challenges/rectangular-game
 * 
 * @author juanespinet
 *
 */
public class RectangularGame {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int numSteps = in.nextInt();
		
		int lowestX = in.nextInt();
		int lowestY = in.nextInt();
		
		for (int i = 1; i < numSteps; i++) {
			int currentX = in.nextInt();
			int currentY = in.nextInt();
			
			lowestX = currentX < lowestX ? currentX : lowestX;
			lowestY = currentY < lowestY ? currentY : lowestY;
		}
		
		System.out.println((long) lowestX * lowestY);
		
		in.close();
	}
}