package expand.random.range.from5.to7;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by yish on 9/2/2016.
 */
public class ExpandRandomRange {

    // Assume that you already have a random5 method.
    private static int random5() {
        return new Random().nextInt(5) + 1;
    }

    // Create a random7() method from the random5() method.
    private static int random7() {
        int[][] randomValueArray = {
                {1, 2, 3, 4, 5},
                {6, 7, 1, 2, 3},
                {4, 5, 6, 7, 1},
                {2, 3, 4, 5, 6},
                {7, 0, 0, 0, 0}};

        int pickupValue = 0;
        while(pickupValue == 0) {
            int i = random5();
            int j = random5();

            pickupValue = randomValueArray[i - 1][j - 1];
        }

        return pickupValue;
    }

    public static void main(String[] args) {
        // Testing..
        IntStream.range(0, 100)
                .parallel()
                .forEach(i -> {
            System.out.println(random7());
        });

    }
}
