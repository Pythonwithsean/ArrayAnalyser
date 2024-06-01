import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * A main class to test the ArrayAnalyser class.
 * 
 * @author Sean Idisi
 * @version 1.0
 */
public class Main {
    public static final String CAMPUS_NAME = "Canterbury";

    /**
     * The main method for testing the ArrayAnalyser.
     * 
     * @param args Not used.
     * @throws IOException If the file cannot be read.
     */
    public static void main(String[] args)
            throws IOException {
        System.out.printf("Array Analyser for %s%n", CAMPUS_NAME);

        // Read the data into a list of strings.
        Path filePath = Paths.get("numbersfile.txt");
        List<String> theData = Files.readAllLines(filePath);

        // Convert the list of Strings into an array of int values.
        int[] numbers = convertInput(theData);

        // Set up the analyser.
        ArrayAnalyser analyser = new ArrayAnalyser(numbers);
        // Test the analyser.
        System.out.println("Test with the real data.");
        testTheAnalyser(analyser);

        // Here is a smaller data set that will be easier to check the results of.
        // Sum is 34, max is 8, most frequent is 3, unique count is 4.
        int[] smallDataSet = {
                3, 5, 2, 3, 1, 7, 5, 8,

        };
        ArrayAnalyser smallAnalyser = new ArrayAnalyser(smallDataSet);
        System.out.println("Test with a small amount of data.");
        testTheAnalyser(smallAnalyser);

    }

    /**
     * Convert each String in the list to an int value and
     * store it into an array.
     * 
     * @param theData The data to be converted to int values.
     * @return The array of integers from the converted data.
     */
    public static int[] convertInput(List<String> theData) {
        int[] nums = new int[theData.size()];
        for (int i = 0; i < theData.size(); i++) {
            int numData = Integer.parseInt(theData.get(i));
            nums[i] += numData;
        }
        return nums;

    }

    /**
     * Call the analysers methods to test that it is returning
     * the correct values.
     * Print out the results of each test.
     * For instance, call its 'sum' method to check that it
     * returns the sum of all the numbers in the analyser's array.
     * 
     * @param analyser The analyser to be tested.
     */
    public static void testTheAnalyser(ArrayAnalyser analyser) {
//        int sum = analyser.getSum();
//        System.out.println("Sum is " + sum);
//        int Max = analyser.getMax();
//        System.out.println("Max is " + Max);
//        System.out.println("Most frequent is " + analyser.getSmallestMostFrequent());
//        System.out.println("Unique count is " + analyser.getUniqueCount());
//        System.out.println("Delivery order is: ");
//        analyser.printDeliveryOrder();

    }

}
