package sorted.vs.unsorted.array;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Created by y1sh on 5/21/17.
 */
public class SortedVsUnsortedArray {

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE / 21;

    private static final int MAX_VALUE = 100000000;

    private static final int THRESHOLD = 50000000;

    private static int[] createArray() {
        Random random = new Random();

        int[] array = new int[MAX_ARRAY_SIZE];
        IntStream.range(0, array.length)
                .forEach(i -> array[i] = random.nextInt(MAX_VALUE));

        return array;
    }

    private static int sumWithLegacyLoop(int[] array) {
        int sum = 0;

        for(int value : array) {
            if (value < THRESHOLD) {
                sum += value;
            }
        }

        return sum;
    }

    private static int sumWithStream(int[] array) {
        int sum = Arrays.stream(array)
                .parallel()
                .filter(value -> value < THRESHOLD)
                .sum();

        return sum;
    }

    // https://www.oreilly.com/learning/does-a-sorted-array-run-faster-than-an-unsorted-array-in-java
    // You can see a kind of interesting result when using 'greater than' condition.
    public static void main(String[] args) {
        int[] unsortedArray = createArray();
        int[] sortedArray = createArray();
        Arrays.sort(sortedArray);

        long unsortedArrayStartTime = System.nanoTime();
        sumWithLegacyLoop(unsortedArray);
        long unsortedArrayEndTime = System.nanoTime();

        System.out.println("Unsorted array when use legacy loop : " + TimeUnit.NANOSECONDS.toMillis(unsortedArrayEndTime - unsortedArrayStartTime) + "ms");

        unsortedArrayStartTime = System.nanoTime();
        sumWithStream(unsortedArray);
        unsortedArrayEndTime = System.nanoTime();

        System.out.println("Unsorted array when use stream : " + TimeUnit.NANOSECONDS.toMillis(unsortedArrayEndTime - unsortedArrayStartTime) + "ms");

        long sortedArrayStartTime = System.nanoTime();
        sumWithLegacyLoop(sortedArray);
        long sortedArrayEndTime = System.nanoTime();

        System.out.println("Sorted array when use legacy loop : " + TimeUnit.NANOSECONDS.toMillis(sortedArrayEndTime - sortedArrayStartTime) + "ms");

        sortedArrayStartTime = System.nanoTime();
        sumWithStream(sortedArray);
        sortedArrayEndTime = System.nanoTime();

        System.out.println("Sorted array when use stream : " + TimeUnit.NANOSECONDS.toMillis(sortedArrayEndTime - sortedArrayStartTime) + "ms");
    }
}
