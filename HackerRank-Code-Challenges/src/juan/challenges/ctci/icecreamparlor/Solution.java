package juan.challenges.ctci.icecreamparlor;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int m = in.nextInt();
            int n = in.nextInt();
            
            Flavor[] flavors = new Flavor[n];
            for(int a_i=0; a_i < n; a_i++){
            	// get all flavors and costs
                flavors[a_i] = new Flavor(a_i + 1, in.nextInt());
            }
            
            // find a pair of costs that exactly equals m
            Flavor[] pair = findPairForPrice(m, flavors);
            System.out.println(pair[0].id + " " + pair[1].id);
        }
        
        in.close();
    }
    
    /**
     * Performs a binary search through an array of
     * flavors to find one of a specific cost.
     * 
     * @param price
     * @param flavors
     * @return Flavor
     */
    public static Flavor searchForPrice(int price, int lower, int upper, Flavor[] flavors) {
    	int mid = Math.floorDiv(upper + lower, 2);
    	Flavor current = flavors[mid];
    	
    	if (current.cost == price) return current;
    	
    	if (lower == upper) return null;
    	
    	if (current.cost > price) return searchForPrice(price, lower, mid, flavors);
    		
    	return searchForPrice(price, mid + 1, upper, flavors);
    }
    
    /**
     * Finds a pair of two distinct flavors for which the cost
     * adds up to a given price. Note that this method assumes
     * that there is at least one pair of distinct flavors
     * that will add up to exactly the given price.
     * 
     * @param price
     * @param flavors
     * @return
     * @throws InterruptedException
     */
    public static Flavor[] findPairForPrice(int price, Flavor[] flavors) {
    	// sort flavors by cost
        Arrays.sort(flavors);
        
        Flavor[] result = new Flavor[2];
        
        // check each value for a matching value
        for (int i = 0; i < flavors.length; i++) {
			Flavor search = searchForPrice(price - flavors[i].cost, i + 1, flavors.length - 1, flavors);
			
			if (search != null) {
				// put our results in the required order
				if (flavors[i].id < search.id) {
		        	result[0] = flavors[i];
		        	result[1] = search;
		        } else {
		        	result[0] = search;
		        	result[1] = flavors[i];
		        }
				break;
			}
		}

        return result;
    }
}

class Flavor implements Comparable<Flavor> {
	int id;
	int cost;

	public Flavor(int id, int cost) {
		this.id = id;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Flavor o) {
		Integer cost = this.cost;
		return cost.compareTo(o.cost);
	}
	
}