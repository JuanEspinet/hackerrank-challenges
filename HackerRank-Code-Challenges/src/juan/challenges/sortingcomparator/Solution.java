package juan.challenges.sortingcomparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * Solution to hackerrank challenge Sorting: Comparator
 * found at: https://www.hackerrank.com/challenges/ctci-comparator-sorting
 * 
 * 
 * @author juanespinet
 *
 */

/**
 * This class is from a locked code stub in the challenge
 */
class Player{
    String name;
    int score;
    
    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

/**
 * This class is from a locked code stub in the challenge
 */
class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();
        
        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}

/**
 * This is the solution I wrote
 * 
 * @author juanespinet
 *
 */
class Checker implements Comparator<Player> {

	@Override
	public int compare(Player o1, Player o2) {
		if (o1.score == o2.score) {
			return compareAlpha(o1, o2);
		}
		
		return o2.score - o1.score;
	}
	
	/**
	 * Compares the name properties for two player
	 * instances and returns a value indicating their
	 * alphabetical ordering.
	 * 
	 * @param o1
	 * @param o2
	 * @return int
	 */
	public int compareAlpha(Player o1, Player o2) {
		// compare characters in order until a mismatch is found
		for (int i = 0; i < o1.name.length() && i < o2.name.length(); i++) {
			char c1 = o1.name.charAt(i);
			char c2 = o2.name.charAt(i);
			
			if (c1 != c2) {
				// found a character difference, determine order
				return (int) (c1 - c2);
			}
		}
		
		// reached the end of at least one word with no character mismatches
		// compare length
		return o1.name.length() - o2.name.length();
	}
}