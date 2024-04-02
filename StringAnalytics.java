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
        // throw new UnsupportedOperationException("Not implemented yet.");
        //

        int unique = 0;

        if (a.size() > 0) {
            unique++; // the first element is always unique
        }

        for (int i = 1; i < a.size(); i++){
            String current = a.get(i);
            if (!Objects.equals(current, a.get(i - 1))){ // if current is not equals to the string before
                unique++; // add to the unique counter
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
        //throw new UnsupportedOperationException("Not implemented yet.");

        int palindromeCounter = 0;


        for(int i=0; i < a.size(); i++){
            String current = a.get(i);
            int first = 0;
            int last = current.length() - 1;
            boolean palindrome = true;

            while (first < last) {
                if (current.charAt(first) != current.charAt(last))
                    palindrome = false;
                first++;
                last--;
            }

            if (palindrome){
                palindromeCounter++;
            }

        }

        return palindromeCounter;
    }



    /**
     * Search for a string in an ordered collection
     * @param a collection of strings, in ascending order
     * @return element that occurs the least frequent in the list. If two or more are equally least frequent, return the one that comes earliest
     */
    public String leastFrequent (StringList a) { 
        // replace the following line with your implementation
        //throw new UnsupportedOperationException("Not implemented yet.");

        String leastFrequent = null;
        int max = Integer.MAX_VALUE;

        for (int i = 0; i < a.size(); i++){
            String current = a.get(i);
            int frequent = 1; // set the frequency of the string to 1

            // count how frequent is the current string is
            while (i < a.size() - 1 && a.get(i).equals(a.get(i+1))){
                // check if current is less than the size of the list minus one
                // and if the current string is equal to the next string
                frequent++;
                i++;
            }

            if (frequent < max){ // check if the frequency of the current is less than frequency stored
                max = frequent;
                leastFrequent = current;
            }


        }

        return leastFrequent;

    }



    /**
     * Search for a string in an ordered collection
     * @param a collection of strings, in ascending order
     * @param str string to search for
     * @return number of strings less than k in order
     */
    public int countLess(StringList a, String str) {
        // replace the following line with your implementation
        //throw new UnsupportedOperationException("Not implemented yet.");

        // binary search
        int low = 0;
        int high = a.size();
        int index = 0;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (mid < a.size() && a.get(mid).compareTo(str) < 0) { // if the middle value is smaller than the size and smaller than str
                low = mid + 1;
                index = mid;
            } else { // anything bigger than str
                high = mid - 1; // update the new highest string to string before middle
            }
        }

        return index;
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
        //throw new UnsupportedOperationException("Not implemented yet.");

        // binary search
        int low = 0;
        int high = a.size() - 1; // Adjust high to the last valid index
        int index = 0;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (a.get(mid).compareTo(str) >= 0) { // if the middle value is greater or equal to str
                high = mid - 1;
            } else { // anything smaller than str
                low = mid + 1;
                index = mid + 1;
            }
        }

        return index;
    }



    /**
     * Search for a string in an ordered collection
     * @param a - collection of strings, in ascending order
     * @param prefix - prefix string
     * @return number of strings having prefix in collection of strings
     */
    public int countPrefix(StringList a, String prefix) {
        // replace the following line with your implementation
        //throw new UnsupportedOperationException("Not implemented yet.");

        int count = 0;

        for (int i = 0; i < a.size(); i++){
            String current = a.get(i);

            if (current.startsWith(prefix)){
                count++;
            }

            if (current.compareTo(prefix) > 0){
                break;
            }

        }

        return count;

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
