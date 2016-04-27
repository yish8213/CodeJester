package reverse.number;

/**
 * Created by y1sh on 4/27/16.
 */
public class ReverseNumber {
    public static void main(String[] args) {
        int number = 987654321;
        int reverse = 0;

        while(number != 0) {
            reverse *= 10; // Move ones' digit value to the tens' digit value.
            reverse += number % 10; // Get ones' place value and sum with previous reversed value.
            number /= 10; // Remove ones' place value in the original number.
        }

        System.out.println(reverse);
    }
}
