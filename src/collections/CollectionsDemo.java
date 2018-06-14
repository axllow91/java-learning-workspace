package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo {
    public static void main(String[] args) {
        // boolean addAll(Collection<? super T> c, T... elements);
        List<String> list = new ArrayList<>();
        list.add("Me");
        list.add("You");
        list.add("Gim");

        String[] array = {"Me"};

        /* Adds all of the specified elements to the specified collection.
          Elements to be added may be specified individually or as an array.
         The behavior of this convenience method is identical to that of c.addAll(Arrays.asList(elements)),
         but this method is likely to run significantly faster under most implementations.*/
        // faster then the approach shown down
        Collections.addAll(list, array);

        System.out.println("list: " + list);

        //this is
        // list.addAll(Arrays.asList(array));

        // Sorting (static <T extends Comparable<? super T>> void sort(List<T> list)
        Collections.sort(list);
        System.out.println("sortedList: " + list);

        // <T> int binarySearch(List<? extends Comparable<? super T>> list, T key);
        // Needs to be sorted. O(log(n))
        // Searches the specified list for the specified object using the binary search algorithm
        // The list must be sorted into ascending order according to the natural ordering of its elements (as by the sort(List) method) prior to making this call
        System.out.println("element found at " + Collections.binarySearch(list, "You"));
        System.out.println("element found at " + Collections.binarySearch(list, "Me"));

        // reverse
        Collections.reverse(list);
        System.out.println("reversed list: " + list);

        // swap
        Collections.swap(list, 2, 0);
        System.out.println("swapped list: " + list);

        // frequency
        /*Returns the number of elements in the specified collection equal to the specified object. More formally,
        returns the number of elements e in the collection such that (o == null ? e == null : o.equals(e)).
        */
        System.out.println("# You: " + Collections.frequency(list, "You"));

        // shuffle
        /*Randomly permutes the specified list using a default source of randomness.
        All permutations occur with approximately equal likelihood.
        * */
        Collections.shuffle(list);
        System.out.println("Shuffled list: " + list);

        // Returns the maximum element of the given collection, according to the natural ordering of its elements.
        // All elements in the collection must implement the Comparable interface
        System.out.println("Max: " + Collections.max(list));


        // Returns the minimum element of the given collection, according to the natural ordering of its elements.
        // All elements in the collection must implement the Comparable interface.
        System.out.println("Min: " + Collections.min(list));

        // Returns an immutable set containing only the specified object. The returned set is serializable.
        list.removeAll(Collections.singleton("Gim"));


    }
}
