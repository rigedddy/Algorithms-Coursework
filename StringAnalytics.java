import java.util.*;

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

        if (a.size() == 0) {
            return(0); // check if the file is empty
        }

        // make two array lists to check if the elements are unique
        ArrayList<String> unique =  new ArrayList<>();
        ArrayList<String> notUnique = new ArrayList<>();


        for (int i = 0; i < a.size() - 1; i++){
            String current = a.get(i);
            String next = a.get(i+1);
            if (!current.equals(next) && !notUnique.contains(current)){ // if current is not equals to the string before
                unique.add(current); // add to the unique counter
            }
            else {
                notUnique.add(current);
            }
        }

        String last = a.get(a.size() - 1);
        if (!notUnique.contains(last)){
            unique.add(last);
        }

        return unique.size();
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
                if (current.charAt(first) != current.charAt(last)) {
                    palindrome = false;
                    break;
                }
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
        int high = a.size() - 1;
        int index = -1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (a.get(mid).compareTo(str) < 0) { // if the middle value is smaller than the size and smaller than str
                low = mid + 1;
                index = mid;
            } else { // anything bigger than str
                high = mid - 1; // update the new highest string to string before middle
            }
        }

        return index + 1; // count the string given as well as the previous ones
    }



    /**
     * Search for a string in an ordered collection
     * @param a collection of strings, in ascending order
     * @param k integer - top k
     * @return k most frequent elements in the list
     */
    public String[] topKFrequent(StringList a, int k) {
        // replace the following line with your implementation
        //throw new UnsupportedOperationException("Not implemented yet.");

        HashMap<String, Integer> freqMap = new HashMap<>();

        // loop through list and add values to the freq map
        for (int i = 0; i < a.size(); i++) {
            String element = a.get(i);
            freqMap.put(element, freqMap.getOrDefault(element, 0) + 1);
        }

        // list for sorting values based on their frequency
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(freqMap.entrySet());
        sortedEntries.sort((entry1, entry2) -> entry2.getValue() - entry1.getValue());

        // array to store top most frequent values
        String[] topK = new String[k];

        // populating the topk array with the most frequent elements
        for (int i = 0; i < k; i++) {
            if (i < sortedEntries.size()) {
                topK[i] = sortedEntries.get(i).getKey();
            } else {
                break; // Break if there are fewer than k elements in the frequency map
            }
        }

        return topK;
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
        int high = a.size() - 1;
        int index = a.size();

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (a.get(mid).compareTo(str) >= 0) { // if the middle value is greater or equal to str
                index = mid;
                high = mid - 1;
            } else { // anything smaller than str
                low = mid + 1;
            }
        }

        return a.size() - index; // calculate the count of elements greater than or equal to str
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

            if (current.startsWith(prefix)){ // if the elements starts with the prefix
                count++;
            }

        }

        return count;

    }

    /**
     * Count number of unmatches in an ordered collection
     * @param a collection of strings, in ascending order
     * @param prefix first string to search for
     * @param substring second string to search for
     * @return cou
     */
    public int countUnMatches(StringList a, String prefix, String substring) {
        // replace the following line with your implementation
        //throw new UnsupportedOperationException("Not implemented yet.");

        int count = 0;

        for (int i = 0; i < a.size(); i++) {
            String current = a.get(i);
            // if the current element neither starts with the prefix nor contains the substring, doesn't need to be overlap always
            if (!current.startsWith(prefix) || !current.contains(substring)) {
                count++;
            }
        }

        return count;
    }

}
