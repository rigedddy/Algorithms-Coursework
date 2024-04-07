import java.io.IOException;
import java.util.Arrays;

/**
 * Test program for the Search class.
 */
public class StringTest {
    private static final String files[] = {
        "tiny.txt", "small.txt", "medium.txt", "large.txt"
    };
    
    /**
     * Test program for the StringAnalytics class.
     * Put whatever tests you like in the body of the method.
     * @param args the command line arguments
     * @throws java.io.IOException of error reading the input
     */
    public static void main(String[] args) throws IOException {
        // Don't change this line
        final StringAnalytics sa = new StringAnalytics();
        //final String method = args[0];
        
        for (String file : files) {
            final StringList strings = new StringList("data/" + file);
            System.out.println("Testing on " + file + ":");

            // add your tests here

            // shortest word
            System.out.println("Shortest word: " + sa.shortestWord(strings));

            // unique
            System.out.println("Unique words: " + sa.countUnique(strings));

            // palindrome
            System.out.println("Palindrome words: " + sa.countPalindrome(strings));

            // least frequent
            System.out.println("Least frequent word: " + sa.leastFrequent(strings));

            // count less
            System.out.println("Count everything less than chosen string: " + sa.countLess(strings, "the"));

            // top k
            String[] topKFrequent = sa.topKFrequent(strings,5);
            System.out.println("Most frequent elements in the list: " + Arrays.toString(topKFrequent));

            // count greater or equal
            System.out.println("Count everything greater or equal to chosen string: " + sa.countGreaterOrEqual(strings, "them"));

            // prefix
            System.out.println("Count the amount of words with the certain prefix: " + sa.countPrefix(strings, "pre"));

            // substring
            System.out.println("Count number of elements that neither start with \nthe specified prefix nor contain the given substring: " + sa.countUnMatches(strings, "an", "want"));


            System.out.println();
        }
    }
    
}
