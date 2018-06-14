package collections;

import java.util.*;

public class ListDemo {

    private static List<Integer> arrayListDemo() {

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(1);
        list1.add(3);
        list1.add(4);
        list1.add(null);

        System.out.println("list1: " + list1);

        list1.remove(3);
        System.out.println("list1: " + list1);

        list1.remove(3);
        System.out.println("list1: " + list1);

        list1.add(0, 10);
        System.out.println("list1: " + list1);

        list1.set(1, 20);

        System.out.println("list1: " + list1);


        // Bulk operations
        Collection<Integer> list2 = new ArrayList<>();
        list2.add(10);
        list2.add(20);

        // Removes from this list all of its elements that are contained in the specified collection.
        list1.removeAll(list2);

        System.out.println("list2: " + list2);
        System.out.println("list1: " + list1);

        // Retains only the elements in this list that are contained in the specified collection.
        // In other words, removes from this list all of its elements that are not contained in the specified collection
        list1.retainAll(list2);

        System.out.println("list1: " + list1);

        list1.add(1);
        list1.add(4);

        /**
         * Appends all of the elements in the specified collection to the end of this list, in the order that they are returned by the specified collection's Iterator.
         * The behavior of this operation is undefined if the specified collection is modified while the operation is in progress.
         * (This implies that the behavior of this call is undefined if the specified collection is this list, and this list is nonempty.)
         */
        list1.addAll(list2);
        System.out.println("list1: " + list1);

        // Replaces the element at the specified position in this list with the specified element
        System.out.println("list1.set(2,2): " + list1.set(2,2));
        System.out.println("list1: " + list1);

        // Search

        list1.add(1);

        //Returns true if this list contains the specified element. More formally,
        // returns true if and only if this list contains at least one element e such that (o==null ? e==null : o.equals(e)).
        System.out.println("list1.contains(4): " + list1.contains(4));


        //Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
        // More formally, returns the lowest index i such that (o==null ? get(i)==null : o.equals(get(i))), or -1 if there is no such index.
        System.out.println("list1.indexOf(2): " + list1.indexOf(20));

        //Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element.
        // More formally, returns the highest index i such that (o==null ? get(i)==null : o.equals(get(i))), or -1 if there is no such index.
        System.out.println("list1.lastIndexOf(4): " + list1.lastIndexOf(1));
        System.out.println("list1: " + list1);

        // Range view
        // Returns a portion of the view from the firstIndex to the lastIndex specified(included)
        List<Integer> list3 = list1.subList(2,3);
        list3.set(0,6);
        System.out.println("list1: " + list1);
        list3.add(0,7);
        System.out.println("list3: " + list3);
        System.out.println("list1: " + list1);
        list1.set(2,8);
        System.out.println("list3: " + list3);


        // we cannot change the list
        // it will throw and exception CurrentModificationException
        //list1.add(0, 8);
        //System.out.println("list3: " + list3);

        System.out.println("list1: " + list1);

        /*for(int element : list1) {
            System.out.println("element: " + element);

            // Generates ConcurrentModifactionException
            if (element == 9)
                list1.remove(Integer.valueOf(element));

        }*/
        return list1;
    }

    private static void iteratorDemo(List<Integer> list1) {
        System.out.println("\nInside iteratorDemo() ...");

        Iterator<Integer> iterator = list1.iterator();
        //Returns true if the iteration has more elements. (In other words, returns true if next would return an element
        // rather than throwing an exception.
        while(iterator.hasNext()) {
            // if it is true return the next element
            int element = iterator.next();
            System.out.println("element: " + element);

            if(element == 6)
                iterator.remove();
        }
        System.out.println("list1: " + list1);
    }

    static void listIteratorDemo() {
        System.out.println("\nInside listIteratorDemo() ...");

        List<String> list = new ArrayList<>();
        list.add("m");
        list.add("i");
        list.add("g");

        System.out.println("list: " + list);

        System.out.println("\nDisplaying current elements in the arrayList ...");
        for(ListIterator<String> iterator = list.listIterator(); iterator.hasNext();) {
            System.out.println("iterator.nextIndex: " + iterator.nextIndex() +
                    ", iterator.next: " + iterator.next());
        }

        System.out.println("\nDemonstrating add, remove, and set Operations");
        for(ListIterator iterator = list.listIterator(); iterator.hasNext();) {
            System.out.println("iterator.nextIndex: " + iterator.nextIndex() + ", iterator.next: " + iterator.next());
            if(iterator.nextIndex() == 1) {
                System.out.println("*** Adding test at index 1");
                iterator.add("test");
                System.out.println("iterator.nextIndex: " + iterator.nextIndex() + ", iterator.next: " + iterator.next());

                System.out.println("Removing test that was added at index 1");
                iterator.previous(); // i
                iterator.previous(); // test
                iterator.remove(); // removes test

                // line below gives an IllegalStateException as
                // set should be preceded by next/previous/set
                // so here set is preceded by remove so that's why we get an exception
                // iterator.set("test");
                System.out.println("iterator.nextIndex: " + iterator.nextIndex() + ", iterator.next: " + iterator.next());
                System.out.println("Setting element at index 1 as test");
                iterator.set("test");
                System.out.println("Setting an element at index 1 as test1 to show that two set operations ca be invoked sequentially");
                iterator.set("test1");
           }
        }
    }

    public static void main(String[] args) {
        //arrayListDemo();
        //List<Integer> list1 = arrayListDemo();
        //iteratorDemo(list1);

        listIteratorDemo();
    }

}
