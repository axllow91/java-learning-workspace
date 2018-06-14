package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysDemo {

    private static void sequential() {
        String[] strArray = new String[] {"Me", "You"};
        // asList() - Returns a fixed-size list backed by the specified array. (Changes to the returned list
        // "write through" to the array.)
        List<String> stringNames = Arrays.asList(strArray); // this arrayList will be a fixed-size (very important)
        System.out.println("String names: " + stringNames);
        // java.lang.UnsupportedOperationException
        // stringNames.remove(0);
        // stringNames.add("a");
        stringNames.set(0, "Them");
        System.out.println("updated stringNames: " + Arrays.toString(strArray));

        // Creating a modifiable ArrayList from an Array
        stringNames = new ArrayList<>(Arrays.asList(strArray));

        // Show varargs
        stringNames = Arrays.asList("Me", "You");

        // Fiexed size arraylist
        List<String> fixedList = Arrays.asList(new String[3]);

        // recall from autoboxing that arrays are not auto-boxable
        // it will not convert from wrap class Integer to the int primitive
        //List<Integer> fixedList2 = Array.asList(new int[2]);
        List<Integer> fixedList2 = Arrays.asList(new Integer[2]);

        // Sorting
        // Partially sorted array: far fewer that nlong(n) comparisons
        // Almost sorted array: aprox. n comparations, where n is array size
        Arrays.sort(strArray);
        System.out.println(Arrays.toString(strArray));

        // Sorting: void sort(int[]) -> uses quick sort
        int[] iArray = {11, 4, 5};
        Arrays.sort(iArray);
        System.out.println("Sorted iArray: " + Arrays.toString(iArray));

        // Binary Search: int binarySearch(int[], int[]);
        // returns index if element found
        // otherwise returns (insertions point) -1
        // input array must be sorted. Otherwise, behavior is undefined
        System.out.println("index return by binary search: " + Arrays.binarySearch(new int[] {4, 23, 44}, 4));

        // adding to the new array a copy of the array and  a new length
        int[] newArray = Arrays.copyOf(iArray, 6);
        System.out.println("newArray: " + Arrays.toString(newArray));

        // starting to copy the element from the iArray from position 0 to the newArray (starting to add from the position 0)
        int[] newArray1 = new int[6];
        System.arraycopy(iArray, 0,newArray1, 0, iArray.length);
        System.out.println("newArray1: " + Arrays.toString(newArray1));

        // fill() -> Assigns the specified int value to each element of the specified array of ints.
        Arrays.fill(newArray, 13);
        System.out.println("Fill with 13? " + Arrays.toString(newArray));

        // Equal()
        System.out.println("Equals>?: " + Arrays.equals(iArray, newArray));

        // Arrays.deepEquals(Object[], Object[])



    }

    public static void main(String[] args) {
        sequential();
    }
}
