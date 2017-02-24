package juan.challenges.ctci.dpcoin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Challenge description at https://www.hackerrank.com/challenges/ctci-coin-change
 * 
 * Solution below by Juan Espinet
 * 
 * @author juanespinet
 *
 */
public class Coin {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Integer coins[] = new Integer[m];
        for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i] = in.nextInt();
        }
        CoinChanger changer = new CoinChanger(coins, n);
        System.out.println(changer.getCombinations());
        in.close();
    }
}

/**
 * Calculates the number of ways a given integer
 * can be partitioned by a given set of "coins" (integer values)
 * for which there is an infinite supply of each.
 * 
 * @author juanespinet
 *
 */
class CoinChanger {
	/**
	 * Hashmap for storing already computed solutions.
	 * 
	 */
	HashMap<SolvedKey, Long> solved;
	
	/**
	 * The set of "coin" values used to make "change"
	 */
	ArrayList<Integer> coins;
	
	/**
	 * The integer value for which we are making "change"
	 */
	int dollars;
	
	public CoinChanger(Integer[] coins, int dollars) {
		this.coins = new ArrayList<Integer>(Arrays.asList(coins));
		Collections.sort(this.coins);
		this.dollars = dollars;
		this.solved = new HashMap<SolvedKey, Long>();
	}
	
	public long getCombinations() {
		return getFromIndex(this.coins.size() - 1, this.dollars);
	}
	
	public long getFromIndex(int coinIndex, int dollarTotal) {
		// invalid combination, no solutions
		if (coinIndex < 0 || dollarTotal < 0) {
			return 0;
		}
		
		// can't use this coin any more, base case reached
		if (dollarTotal == 0) {
			return 1;
		}
		
		// check if a solution has already been calculated for this combination
		SolvedKey key = new SolvedKey(coinIndex, dollarTotal);
		if (this.solved.containsKey(key)) {
			return this.solved.get(key);
		}
		
		// get the value of the current coin in the list
		int coinVal = coins.get(coinIndex);
		
		// continue running down branches
		long combos = getFromIndex(coinIndex - 1, dollarTotal) + getFromIndex(coinIndex, dollarTotal - coinVal);
		// save this solution
		this.solved.put(key, combos);
		
		return combos;
	}
	
	/**
	 * Custom key to use a pair of
	 * integer values as they key. Thanks to
	 * Tomasz Nurkiewicz from stackoverflow.com
	 * 
	 */
	class SolvedKey {

	    private final int x;
	    private final int y;

	    public SolvedKey(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof SolvedKey)) return false;
	        SolvedKey key = (SolvedKey) o;
	        return x == key.x && y == key.y;
	    }

	    @Override
	    public int hashCode() {
	        int result = x;
	        result = 31 * result + y;
	        return result;
	    }

	}
}
