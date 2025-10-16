package edu.grinnell.csc207.soundsofsorting;

import java.util.Arrays;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import edu.grinnell.csc207.soundsofsorting.sorts.Sorts;

public class SortsTests {
    /**
     * @param <T> the carrier type of the array
     * @param arr the array to check
     * @return true iff <code>arr</code> is sorted.
     */
    public static <T extends Comparable<? super T>> boolean sorted(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static Integer[][] makeTestArray() {
        return new Integer[][] {
            // general/random case
            {3, 7, 9, 1, 2, 18, 16, 15, 19, 8,
            14, 12, 5, 13, 4, 6, 0, 17, 11, 10},
            // already sorted case
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 
            11, 12, 13, 14, 15, 16, 17, 18, 19},
            // reverse sorted case
            {19, 18, 17, 16, 15, 14, 13, 12, 11,
            10, 9, 8, 7, 6, 5, 4, 3, 2, 1},
            // all equal (and even # of elems) case
            {5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
            // single elem case
            {1}
        };
    }

    public void testSort(Consumer<Integer[]> func) {
        for (Integer[] arr : makeTestArray()) {
            Integer[] testArr = Arrays.copyOf(arr, arr.length);
            func.accept(testArr);
            assertTrue(sorted(testArr),
                "Failed to sort: " + Arrays.toString(arr));
        }
    }

    @Test
    public void testBubbleSort() {
        testSort(Sorts::bubbleSort);
    }
    
    @Test
    public void testInsertionSort() {
        testSort(Sorts::insertionSort);
    }
    
    @Test
    public void testSelectionSort() {
        testSort(Sorts::selectionSort);
    }

    @Test
    public void testMergeSort() {
        testSort(Sorts::mergeSort);
    }
    
    @Test
    public void testQuickSort() {
        testSort(Sorts::quickSort);
    }

    @Test
    public void testHeapSort() {
        testSort(Sorts::heapSort);
    }
}