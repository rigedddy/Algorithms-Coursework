import java.io.IOException;

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
        final String method = args[0];
        
        for (String file : files) {
            final StringList strings = new StringList("data/" + file);
            System.out.println("Testing on " + file + ":");

            // add your tests here

            System.out.println();
        }
    }
    
}
