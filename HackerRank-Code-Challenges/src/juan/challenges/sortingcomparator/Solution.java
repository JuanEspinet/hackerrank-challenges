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
 * This is the solution
 * 
 * @author juanespinet
 *
 */
class Checker implements Comparator<Player> {

	@Override
	public int compare(Player o1, Player o2) {
		if (o1.score == o2.score) {
			
		}
		
		return 0;
	}
	
	
	public int compareAlpha(Player o1, Player o2) {
		return 0;
	}
}