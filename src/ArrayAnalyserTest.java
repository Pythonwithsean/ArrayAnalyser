import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

class ArrayAnalyserTest
{
    // Catch the output from System.out and System.err.
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    // Error report, if any.
    private String report;

    private final int[] one = { 1977, };
    private final int[] two = { 1982, 1001, };
    private final int[] three = { 1982, 1001, 2020, };
    private final int[] four = { 1982, 1001, 2020, 975, };
    private final int[] twoTheSame = { 2023, 2023, };
    private final int[] twoPairs = { 2023, 1909, 2023, 1909, };

    private int[] theData;
    private ArrayAnalyser theAnalyser;

    @BeforeEach
    void setup()
    {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        report = null;
        theData = null;
        theAnalyser = null;
    }

    @AfterEach
    void tearDown()
    {
        if(report != null) {
            //System.err.println(report);
            report = null;
        }

        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    /**
     * Test getMax with an array of length 1.
     */
    @org.junit.jupiter.api.Test
    void testGetMaxOne()
    {
        theData = one;
        theAnalyser = new ArrayAnalyser(Arrays.copyOf(theData, theData.length));
        int max = theAnalyser.getMax();
        assertEquals(theData[0], max);
    }

    /**
     * Test getMax with an array of length 2.
     */
    @org.junit.jupiter.api.Test
    void testGetMaxTwo()
    {
        theData = two;
        theAnalyser = new ArrayAnalyser(Arrays.copyOf(theData, theData.length));
        int max = theAnalyser.getMax();
        assertEquals(theData[0], max);
    }

    /**
     * Test getSum with an array of length 1.
     */
    @org.junit.jupiter.api.Test
    void testGetSumOne()
    {
        theData = one;
        theAnalyser = new ArrayAnalyser(Arrays.copyOf(theData, theData.length));
        int sum = theAnalyser.getSum();
        assertEquals(theData[0], sum);
    }

    /**
     * Test getSum with an array of length 2.
     */
    @org.junit.jupiter.api.Test
    void testGetSumTwo()
    {
        theData = two;
        theAnalyser = new ArrayAnalyser(Arrays.copyOf(theData, theData.length));
        int sum = theAnalyser.getSum();
        assertEquals(theData[0] + theData[1], sum);
    }

    /**
     * Test getSmallestMostFrequent with an array of length 1.
     */
    @org.junit.jupiter.api.Test
    void testGetSmallestMostFrequentOne()
    {
        theData = one;
        theAnalyser = new ArrayAnalyser(Arrays.copyOf(theData, theData.length));
        int frequent = theAnalyser.getSmallestMostFrequent();
        assertEquals(theData[0], frequent);
    }

    /**
     * Test getSmallestMostFrequent with an array of length 2.
     */
    @org.junit.jupiter.api.Test
    void testGetSmallestMostFrequentTwo()
    {
        theData = two;
        theAnalyser = new ArrayAnalyser(Arrays.copyOf(theData, theData.length));
        int frequent = theAnalyser.getSmallestMostFrequent();
        assertEquals(theData[1], frequent);
    }

    /**
     * Test getSmallestMostFrequent with an array of identical data.
     */
    @org.junit.jupiter.api.Test
    void testGetSmallestMostFrequentTwoTheSame()
    {
        theData = twoTheSame;
        theAnalyser = new ArrayAnalyser(Arrays.copyOf(theData, theData.length));
        int frequent = theAnalyser.getSmallestMostFrequent();
        assertEquals(theData[1], frequent);
    }


    /**
     * Test getSmallestMostFrequent with an array containing
     * two pairs.
     */
    @org.junit.jupiter.api.Test
    void testGetSmallestMostFrequentTwoPairs()
    {
        theData = twoPairs;
        theAnalyser = new ArrayAnalyser(Arrays.copyOf(theData, theData.length));
        int frequent = theAnalyser.getSmallestMostFrequent();
        assertEquals(theData[1], frequent);
    }

    /**
     * Test getSmallestMostFrequent with an array of length 2.
     */
    @org.junit.jupiter.api.Test
    void testGetSmallestMostFrequentThree()
    {
        theData = three;
        theAnalyser = new ArrayAnalyser(Arrays.copyOf(theData, theData.length));
        int frequent = theAnalyser.getSmallestMostFrequent();
        assertEquals(theData[1], frequent);
    }


    @org.junit.jupiter.api.Test
    void testGetUniqueCountOne()
    {
        theData = one;
        theAnalyser = new ArrayAnalyser(Arrays.copyOf(theData, theData.length));
        int count = theAnalyser.getUniqueCount();
        assertEquals(1, count);
    }

    @org.junit.jupiter.api.Test
    void testGetUniqueCountTwo()
    {
        theData = two;
        theAnalyser = new ArrayAnalyser(Arrays.copyOf(theData, theData.length));
        int count = theAnalyser.getUniqueCount();
        assertEquals(2, count);
    }

    @org.junit.jupiter.api.Test
    void testGetUniqueCountZero()
    {
        theData = twoTheSame;
        theAnalyser = new ArrayAnalyser(Arrays.copyOf(theData, theData.length));
        int count = theAnalyser.getUniqueCount();
        assertEquals(0, count);
    }

    @org.junit.jupiter.api.Test
    void testPrintDeliveryOrderOne()
    {
        theData = one;
        theAnalyser = new ArrayAnalyser(Arrays.copyOf(theData, theData.length));
        theAnalyser.printDeliveryOrder();
        String expectedOutput = theData[0] + "";
        String actualOutput = outContent.toString().trim();
        assertEquals(expectedOutput, actualOutput);
    }

    @org.junit.jupiter.api.Test
    void testPrintDeliveryOrderTwo()
    {
        theData = two;
        theAnalyser = new ArrayAnalyser(Arrays.copyOf(theData, theData.length));
        theAnalyser.printDeliveryOrder();
        String expectedOutput = theData[0] + System.lineSeparator() + theData[1];
        String actualOutput = outContent.toString().trim();

        compareDeliveryOrder(expectedOutput, actualOutput);
    }

    @org.junit.jupiter.api.Test
    void testPrintDeliveryOrderTwoTheSame()
    {
        theData = twoTheSame;
        theAnalyser = new ArrayAnalyser(Arrays.copyOf(theData, theData.length));
        theAnalyser.printDeliveryOrder();
        String expectedOutput = theData[0] + "";
        String actualOutput = outContent.toString().trim();

        compareDeliveryOrder(expectedOutput, actualOutput);
    }

    @org.junit.jupiter.api.Test
    void testPrintDeliveryOrderFour()
    {
        theData = four;
        theAnalyser = new ArrayAnalyser(Arrays.copyOf(theData, theData.length));
        theAnalyser.printDeliveryOrder();
        String expectedOutput = theData[0] + " " + theData[2] +
                System.lineSeparator() +
                theData[1] + " " + theData[3];
        String actualOutput = outContent.toString().trim();

        compareDeliveryOrder(expectedOutput, actualOutput);
    }

    /**
     * Check the output from printDeliveryOrder.
     * @param expected The expected output.
     * @param actual The actual output.
     */
    private void compareDeliveryOrder(String expected, String actual)
    {
        String[] expectedLines = expected.split(System.lineSeparator());
        String[] actualLines = actual.split("[\\n\\r]+");
        if(expectedLines.length == actualLines.length) {
            for (int i = 0; i < expectedLines.length; i++) {
                if(! expectedLines[i].trim().equals(actualLines[i].trim())) {
                    assertEquals(expected, actual, "Mismatch in the expected delivery order.");
                }
            }
        }
        else {
            assertEquals(expected, actual, "Mismatch in the number of lines of output.");
        }
    }
}