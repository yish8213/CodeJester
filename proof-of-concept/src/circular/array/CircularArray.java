package circular.array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by y1sh on 4/5/16.
 */
public class CircularArray<E> implements Iterable<E>, Iterator<E> {
    private E[] items;
    private int arraySize;
    private int indexOfIterator = 0;
    private int head = 0; // Index of the first item

    public CircularArray() {
        this.items = null;
        this.arraySize = 0;
    }

    public void add(E obj) {
        if (items == null) {
            items = (E[]) Array.newInstance(Object.class, ++arraySize);
        } else {
            items = Arrays.copyOf(items, ++arraySize);
        }

        items[arraySize - 1] = obj;

    }

    private int convertIndexByTheOffsetValue(int indexValue) {
        return (head + indexValue) % arraySize;
    }

    public E get(int ordinal) {
        if (ordinal < 0 || ordinal > arraySize - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return items[convertIndexByTheOffsetValue(ordinal)];
    }

    public void rotateKnob(int shiftValue) { // This array can rotate left and right.
        if (shiftValue > 0) {
            head = (head + shiftValue) % arraySize;
        } else {
            head = arraySize + (shiftValue % arraySize); // -5 % 3 = -2
        }
    }

    public int size() {
        return arraySize;
    }

    @Override
    public Iterator<E> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        if (indexOfIterator != arraySize) {
            return true;
        } else {
            indexOfIterator = 0;
            return false;
        }
    }

    @Override
    public E next() {
        indexOfIterator++;
        return items[convertIndexByTheOffsetValue(indexOfIterator - 1)];
    }
}