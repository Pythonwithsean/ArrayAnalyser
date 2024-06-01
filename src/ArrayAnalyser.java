import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * An array analyser, that contains a range of methods that can
 * provide information on the data held in its array.
 * 3, 5, 2, 3, 1, 7, 5, 8,
 * 
 * @author Sean Idisi
 * @version 1.0
 */
public class ArrayAnalyser {
    // TODO: Define a field to store the array of numbers.
    int[] nums;

    /**
     * Create an ArrayAnalyser.
     * Store the array parameter into an array field so that it
     * can be accessed by the methods you write.
     * 
     * @param numbers An array of numbers to be analysed.
     */
    public ArrayAnalyser(int[] numbers) {
        // TODO: Store the parameter into a field.
        this.nums = numbers;
    }

    // TODO: Implement the methods of ArrayAnalyser
    public int getSum() {
        int result = 0;
        for (int num : nums) {
            result += num;
        }
        return result;
    }

    public int getMax() {
        return nums.length == 0 ? 0 : Arrays.stream(nums).max().orElse(0);

    }

    public int getUniqueCount() {

        Set<Integer> u = new HashSet<>();
        Set<Integer> flaggedNumbers = new HashSet<>();
        Iterator<Integer> i = Arrays.stream(nums).iterator();
        Arrays.sort(nums);

        while (i.hasNext()) {
            int number = i.next();
            if (!u.contains(number) && !flaggedNumbers.contains(number)) {
                u.add(number);
            } else {
                u.remove(number);
                flaggedNumbers.add(number);
            }

        }
        return u.size();
    }

    public Integer getSmallestMostFrequent() {
        ArrayList<Integer> arr = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], map.getOrDefault(nums[i], 1));
            } else {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        int max = Collections.max(map.values());
        map.entrySet().stream().filter(e -> e.getValue() == max).forEach(e -> arr.add(e.getKey()));
        Collections.sort(arr);
        return arr.get(0);
    }

    public void printDeliveryOrder() {

        Arrays.sort(nums);
        Set<Integer> odd = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                System.out.print(nums[i] + " ");
            } else {
                if (!odd.contains(nums[i]))
                    odd.add(nums[i]);
            }


            if ((i + 1) % 2 == 0) {
                System.out.println();
            }
        }

        ArrayList<Integer> oddList = new ArrayList<>(odd);
        Collections.sort(oddList, Collections.reverseOrder());

        oddList.forEach(num -> System.out.print(num + " "));
        System.out.println();
    }

}
