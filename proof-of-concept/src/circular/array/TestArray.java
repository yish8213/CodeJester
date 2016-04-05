package circular.array;

/**
 * Created by y1sh on 4/5/16.
 */
public class TestArray {
    public static void main(String[] args) {
        CircularArray<String> strArray = new CircularArray<>();

        strArray.add("first");
        strArray.add("second");
        strArray.add("third");

        System.out.println("Size of the array : " + strArray.size());
        System.out.println("Get value before using a knob : " + strArray.get(1));

        System.out.println("Displaying all values in the array : ");
        for (String str : strArray) {
            System.out.println(str);
        }
        System.out.println();

        strArray.rotateKnob(-5); // Rotate left.

        System.out.println("Get value after using a knob : " + strArray.get(1));

        System.out.println("Displaying all values in the array : ");
        for (String str : strArray) {
            System.out.println(str);
        }
        System.out.println();

        CircularArray<Integer> intArray = new CircularArray<>();

        intArray.add(5);
        intArray.add(6);
        intArray.add(7);
        intArray.add(8);
        intArray.add(9);

        System.out.println("Size of the array : " + intArray.size());
        System.out.println("Get value before using a knob : " + intArray.get(1));

        System.out.println("Displaying all values in the array : ");
        for (Integer intValue : intArray) {
            System.out.println(intValue);
        }
        System.out.println();

        intArray.rotateKnob(8); // Rotate right.

        System.out.println("Get value after using a knob : " + intArray.get(1));

        System.out.println("Displaying all values in the array : ");
        for (Integer intValue : intArray) {
            System.out.println(intValue);
        }
        System.out.println();

    }
}