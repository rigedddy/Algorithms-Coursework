import java.util.HashSet;
import java.util.Objects;

/**
 * Class of operations on ordered lists of strings.
 * You must not change the signatures of the methods supplied. 
 * You must not change the signatures of the methods supplied. 
 * You must not change the signatures of the methods supplied. 
 */
public class StringAnalytics {

    /**
     * Returns the shortest string in the list. If there are several
     * strings of the same shortest length, the one that occurs earliest
     * is returned.
     * @param a list of strings, in ascending order
     * @return the shortest string in the list.
     */
    public String shortestWord(StringList a) {
        // replace the following line with your implementation
        //throw new UnsupportedOperationException("Not implemented yet.");

        String shortest = null;
        int shortestLength = Integer.MAX_VALUE;

        for (int i = 0; i < a.size(); i++){ // loop through the text files
            String current = a.get(i);
            if (current.length() < shortestLength){ // check if the current string is less than the largest number
                shortestLength = current.length(); // replace the shortest length with the current length
                shortest = current; // the shortest string is now the current
            }
        }
        return shortest;

    }



    /**
     * Returns the number of unique elements in the list
     * @param a list of strings, in ascending order
     * @return number of unique elements in the list.
     */
    public int countUnique(StringList a) {
        // replace the following line with your implementation
        //throw new UnsupportedOperationException("Not implemented yet.");

        int unique = 0;

        for (int i = 1; i <a.size(); i++){
            String current = a.get(i);
            if (!Objects.equals(current, a.get(i - 1))){
                unique++;
            }
        }


        return unique;
    }
	

    /**
     * Returns the number of palindrome strings in the list.
     * @param a collection of strings, in ascending order
     * @return number of palindrome strings in the list. 
     */
    public int countPalindrome(StringList a) {
        // replace the following line with your implementation
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /**
     * Search for a string in an ordered collection
     * @param a collection of strings, in ascending order
     * @return element that occurs the least frequent in the list. If two or more are equally least frequent, return the one that comes earliest
     */
    public String leastFrequent (StringList a) { 
        // replace the following line with your implementation
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /**
     * Search for a string in an ordered collection
     * @param a collection of strings, in ascending order
     * @param str string to search for
     * @return number of strings less than k in order
     */
    public int countLess(StringList a, String str) {
        // replace the following line with your implementation
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /**
     * Search for a string in an ordered collection
     * @param a collection of strings, in ascending order
     * @param k integer - top k
     * @return k most frequent elements in the list
     */
    public String [] topKFrequent (StringList a, int k) {
        // replace the following line with your implementation
        throw new UnsupportedOperationException("Not implemented yet.");
    }
	

    /**
     * Search for a string in an ordered collection
     * @param a collection of strings, in ascending order
     * @param str string to search for
     * @return number of strings greater than or equal to k in order
     */
    public int countGreaterOrEqual(StringList a, String str) {
        // replace the following line with your implementation
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /**
     * Search for a string in an ordered collection
     * @param a - collection of strings, in ascending order
     * @param prefix - prefix string
     * @return number of strings having prefix in collection of strings
     */
    public int countPrefix(StringList a, String prefix) {
        // replace the following line with your implementation
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /**
     * Count number of unmatches in an ordered collection
     * @param a collection of strings, in ascending order
     * @param prefix first string to search for
     * @param substring second string to search for
     * @return number of elements that neither start with the specified prefix nor contain the given substring
     */
    public int countUnMatches(StringList a, String prefix, String substring) {
        // replace the following line with your implementation
        throw new UnsupportedOperationException("Not implemented yet.");
    }

}
