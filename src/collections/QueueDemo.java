package collections;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueDemo {

    private static void dequeTest() {
        System.out.println("\nInside dequeTest ...");

        // Queue - FIFO
        Deque<String> deque = new ArrayDeque<>();
        deque.add("Walden");
        deque.add("Harry Potter");
        deque.add("Head First Java");

        System.out.println("\n***Printing Queue***");
        //Retrieves and removes the head of the queue represented by this deque.
        // This method differs from poll only in that it throws an exception if this deque is empty.
        // or we can use removeFirst() method
        System.out.println(deque.remove());
        System.out.println(deque.remove());
        System.out.println(deque.remove());


        // Stack - LIFO
        deque.push("Walden");
        deque.push("Harry Potter");
        deque.push("Head First Java");

        System.out.println("\n***Printing Stack***");
        // Pops an element from the stack represented by this deque. In other words,
        // removes and returns the first element of this deque.
        System.out.println(deque.pop());
        System.out.println(deque.pop());
        System.out.println(deque.pop());
    }

    public static void main(String[] args) {
        dequeTest();
    }
}
