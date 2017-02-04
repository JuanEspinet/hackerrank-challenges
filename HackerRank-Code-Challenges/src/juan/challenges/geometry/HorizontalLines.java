package juan.challenges.geometry;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HorizontalLines {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int numPoints = in.nextInt();
		Set xCoords = new HashSet<Integer>();
		Set yCoords = new HashSet<Integer>();
		String result = "YES";
		
		for (int i = 0; i < numPoints; i++) {
			xCoords.add(in.nextInt());
			yCoords.add(in.nextInt());
		}
		
		if (xCoords.size() > 1 && yCoords.size() > 1) {
			result = "NO";
		}
		
		System.out.println(result);
		
		in.close();
	}
}
