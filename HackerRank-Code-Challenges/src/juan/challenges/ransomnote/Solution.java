package juan.challenges.ransomnote;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Challenge description at:
 * https://www.hackerrank.com/challenges/ctci-ransom-note
 * 
 * @author juanespinet
 *
 */
public class Solution {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        // get magazine words
        String magazineWords[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazineWords[magazine_i] = in.next();
        }
        // set up magazine instance
        Magazine magazine = new Magazine(magazineWords);
        // get note words
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
        }
        // set up note instance
        Note ransomNote = new Note(ransom);
        // try to build the note from the magazine
        String built = ransomNote.buildNote(magazine) ? "Yes" : "No";
        
        System.out.println(built);
        
        in.close();
    }
}

class Magazine {
	/**
	 * A list of all words in the magazine with
	 * the number of times they occur.
	 */
	private HashMap<String, Integer> words = new HashMap<String, Integer>();
	
	public Magazine(String[] words) {
		// populate internal word storage
		for (int i = 0; i < words.length; i++) {
			// update count if word already added before
			int count = this.hasWord(words[i]) ? this.getCount(words[i]) + 1 : 1;
			this.words.put(words[i], count);
		}
	}
	
	/**
	 * Indicates whether a given word appears
	 * one or more times.
	 * 
	 * @param word
	 * @return Boolean
	 */
	public boolean hasWord(String word) {
		return words.containsKey(word);
	}
	
	/**
	 * Gets the number of times a given word appears in this magazine.
	 * 
	 * @param word
	 * @return int Number of occurrences
	 */
	public int getCount(String word) {
		return words.get(word);
	}
	
	/**
	 * Removes one existing instance of this word
	 * from the Magazine instance.
	 * 
	 * @param word
	 */
	public void removeWord(String word) {
		if (this.hasWord(word)) {
			int count = this.getCount(word);
			if (count > 1) {
				// more than one occurrence of this word
				// decrement count
				this.words.put(word, count - 1);
			} else {
				this.words.remove(word);
			}
		}
	}
}

/**
 * A representation of a ransom note
 * to be constructed.
 * 
 * @author juanespinet
 *
 */
class Note {
	String[] requiredWords;
	
	public Note(String[] words) {
		this.requiredWords = words;
	}
	
	/**
	 * Tries to construct a note from
	 * a source Magazine by removing those 
	 * words from the Magazine. Stops when it
	 * encounters a word that cannot be taken
	 * from the Magazine.
	 * 
	 * Returns a boolean indicating whether the
	 * note was constructed successfully.
	 * 
	 * @param source The source Magazine
	 * @return boolean Success or failure
	 */
	public boolean buildNote(Magazine source) {
		for (int i = 0; i < requiredWords.length; i++) {
			if (source.hasWord(requiredWords[i])) {
				source.removeWord(requiredWords[i]);
			} else {
				return false;
			}
		}
		return true;
	}
}
