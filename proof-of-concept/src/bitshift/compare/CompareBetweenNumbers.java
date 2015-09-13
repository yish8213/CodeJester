package bitshift.compare;

/**
 * Created by y1sh on 9/13/15.
 */
public class CompareBetweenNumbers {

    // if you need to know about primitive types in java, see below link
    // https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
    public static void main(String[] args) throws Exception {
        int resultInPositive;
        int resultInNegative;

        int bigNumber = 5;
        int smallNumber = 3;

        resultInPositive = bigNumber - smallNumber;
        resultInNegative = smallNumber - bigNumber;

        // remaining sign bit, 0 is positive number, 1 is negative number
        resultInPositive = resultInPositive >>> 31;
        resultInNegative = resultInNegative >>> 31;

        System.out.println("resultInPositive : " + Integer.toBinaryString(resultInPositive));
        System.out.println("resultInNegative : " + Integer.toBinaryString(resultInNegative));

    }
}
