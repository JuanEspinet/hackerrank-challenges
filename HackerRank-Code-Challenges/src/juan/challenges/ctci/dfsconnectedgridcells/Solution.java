package juan.challenges.ctci.dfsconnectedgridcells;

import java.util.Scanner;

/**
 * Solution to a code challenge from HackerRank.com.
 * Challenge description can be found at: https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid
 * @author juanespinet
 *
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        
        NumberGrid gridSearch = new NumberGrid(grid);
        
        System.out.println(gridSearch.largestRegion());
        
        in.close();
    }
}

class NumberGrid {
	private int[][] grid;
	private int largestRegion = 0;
	
	public NumberGrid(int[][] grid) {
		this.grid = grid;
	}
	
	/**
	 * Starting from a set of coordinates, gives
	 * the size of the region those coordinates are
	 * located inside.
	 * 
	 * Note that because this method modifies cell
	 * values, each region can be searched only once.
	 * 
	 * @param y
	 * @param x
	 * @return
	 */
	private int searchRegion(int y, int x) {
		if (y < 0 
				|| x < 0 
				|| y == grid.length 
				|| x == grid[0].length
				|| grid[y][x] != 1) {
			// left the boundaries of the region
			// or landed on an already visited cell
			return 0;
		}
		
		// these are valid coordinates inside the region
		// increment the value so we don't count this twice
		grid[y][x] = 2;
		// keep searching adjacent locations
		return 1 + searchRegion(y - 1, x) 
				+ searchRegion(y - 1, x - 1) 
				+ searchRegion(y + 1, x) 
				+ searchRegion(y + 1, x + 1) 
				+ searchRegion(y, x - 1) 
				+ searchRegion(y + 1, x - 1) 
				+ searchRegion(y, x + 1)
				+ searchRegion(y - 1, x + 1);
	}
	
	/**
	 * Searches this grid and finds the
	 * size of the largest region.
	 * 
	 * @return Integer largest region size
	 */
	public int largestRegion() {
		int largest = largestRegion;
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					int current = searchRegion(i, j);
					if (current > largest) {
						largest = current;
					}
				}
			}
		}
		
		return largest;
	}
}
