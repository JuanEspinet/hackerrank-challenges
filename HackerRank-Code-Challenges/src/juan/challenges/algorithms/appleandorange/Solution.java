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
        
        House myHouse = new House(s, t);
        FruitTree appleTree = new FruitTree(a);
        FruitTree orangeTree = new FruitTree(b);
        
        System.out.println(myHouse.dropAllFruit(apple, appleTree));
        System.out.println(myHouse.dropAllFruit(orange, orangeTree));
    }
}

class House {
	protected final int leftEdge;
	protected final int rightEdge;
	
	public House(int left, int right) {
		this.leftEdge = left;
		this.rightEdge = right;
	}
	
	public boolean isOnHouse(int coord) {
		return (coord >= leftEdge) && (coord <= rightEdge);
	}
	
	/**
	 * Takes an array of relative positions and a FruitTree
	 * object and returns how many of these fruit landed on
	 * the roof of this house.
	 * 
	 * @param fruitRelativePositions
	 * @param tree
	 */
	public int dropAllFruit(int[] fruitRelativePositions, FruitTree tree) {
		int fruitOnRoof = 0;
		
		for (int i = 0; i < fruitRelativePositions.length; i++) {
			if (this.isOnHouse(tree.dropFruit(fruitRelativePositions[i]))) {
				fruitOnRoof++;
			}
		}
		
		return fruitOnRoof;
	}
}

class FruitTree {
	protected final int position;
	
	public FruitTree(int position) {
		this.position = position;
	}
	
	/**
	 * Returns the absolute coordinate of a dropped
	 * piece of fruit given a position relative to the
	 * tree.
	 * 
	 * @param relativePosition
	 * @return
	 */
	public int dropFruit(int relativePosition) {
		return position + relativePosition;
	}
}