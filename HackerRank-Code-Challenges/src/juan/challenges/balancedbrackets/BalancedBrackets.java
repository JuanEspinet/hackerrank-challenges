package juan.challenges.balancedbrackets;

import java.util.*;

/**
 * A bit of code for checking balanced brackets.
 * Detailed challenge description at: https://www.hackerrank.com/challenges/ctci-balanced-brackets
 */
public class BalancedBrackets {
    
    public static boolean isBalanced(String expression) {
    	// create a stack to hold the sequence of opening brackets
        Stack<Character> expectedClose = new Stack<Character>();
        
        // traverse the expression
        for (int i = 0; i < expression.length(); i++) {
			// check if the current char is an opening bracket
        	char current = expression.charAt(i);
        	Character nextClose = BalancedBrackets.getMatchingClose(current);
        			
        	// if so, push corresponding close bracket onto the expected stack
        	if (nextClose != null) {
        		expectedClose.push(nextClose);
        	} else if (!expectedClose.isEmpty()
        			&& expectedClose.peek().equals(current)) {
        		// if not, this is a closing bracket, check to make sure it is expected
        		// if so, remove it from the expected stack and keep going
        		expectedClose.pop();
        	} else {
        		// if not, this set of brackets is unbalanced, we can stop
        		return false;
        	}
		}
        
        // end of string reached, check if still unmatched openers
        if (expectedClose.isEmpty()) {
        	// no unmatched openers, balanced
        	return true;
        }
        // unmatched openers, not balanced
        return false;
    }
    
    public static Character getMatchingClose(char open) {
    	switch (open) {
		case '{':
			return '}';
		case '[':
			return ']';
		case '(':
			return ')';
		default:
			return null;
		}
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
        in.close();
    }
}
