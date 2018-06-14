package collections;

import java.util.*;

public class SetDemo {

    private static void hashSetDemo() {
        System.out.println("\nInside hashSetDemo() ...");

        Set<String> set1 = new HashSet<>();
        set1.add("a");
        set1.add("b");
        set1.add("a");

        System.out.println("set1: " + set1);

        //
        Book book1 = new Book("Walden", "Henry Thoreau", 1854);
        Book book2 = new Book("Walden", "Henry Thoreau", 1854);
        Set<Book> set2 = new HashSet<>();
        set2.add(book1);
        set2.add(book2);

        System.out.println("set2: " + set2);

    }

    private static void linkedHashSetDemo() {
        System.out.println("\nInside linkedHashSetDemo() ...");

        // HashSet does not preserve the order of insertion
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Raj");
        hashSet.add("John");
        hashSet.add("Anita");

        System.out.println("hashSet: " + hashSet);

        // LinkedHashSet preserves the order of insertion
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Raj");
        linkedHashSet.add("John");
        linkedHashSet.add("Anita");

        System.out.println("linkedHashSet: " + linkedHashSet);

    }

    private static void treeSetDemo() {
        System.out.println("\nInside treeSetDemo() ...");

        Book book1 = new Book("Harry Potter", "J.K. Rowling", 1997);
        Book book2 = new Book("Harry Potter", "J.K. Rowling", 1997);
        Book book3 = new Book("Walden", "Henry David Thoreau", 1854);
        Book book4 = new Book("Effective Java", "Joshua Bloch", 2008);

        Set<Book> books = new TreeSet<>(new TitleComparator());
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);


        for(Book book : books)
            System.out.println(book);

    }

    private static void treeSetDemo2() {
        NavigableSet<Integer> set = new TreeSet<>();
        set.add(5);
        set.add(23);
        set.add(75);
        set.add(33);
        set.add(89);

        // Returns the greatest element in this set strictly less than the given element, or null if there is no such element.
        System.out.println("lower: " + set.lower(75));
        //Returns the greatest element in this set less than or equal to the given element, or null if there is no such element
        System.out.println("floor: " + set.floor(75));
        // Returns the least element in this set greater than or equal to the given element, or null if there is no such element.
        System.out.println("ceiling: " + set.ceiling(75));
        //Returns the least element in this set strictly greater than the given element, or null if there is no such element
        System.out.println("higher: " + set.higher(75));

        System.out.println("\nfirst: " + set.first());
        System.out.println("last: " + set.last());

        System.out.println("\nset: " + set);

        //Returns a reverse order view of the elements contained in this set.
        NavigableSet<Integer> descendingSet = set.descendingSet();
        System.out.println("descendingSet: " + descendingSet);

        // Returns a view of the portion of this set whose elements are less than (or equal to, if inclusive is true) toElement.
        // if true ( element is included/false less then the position of the element >)
        NavigableSet<Integer> headSet = set.headSet(75, true);
        System.out.println("headSet: " + headSet);

        headSet.add(6);
        System.out.println("headSet: " + headSet);
        System.out.println("set: " + set);
        headSet.add(4);
        // Exception: key out of range -> needs to be less then 75 or equal to it
        // because we are adding the the headSet and not in the set
        // headSet.add(76);
        System.out.println("set: " + set);

        SortedSet<Integer> subset = set.subSet(5, 75);
        // Exception: key out of range the subset needs to be higher or equal to the border elements
        // subset.add(2);
        subset.add(5);

        set.add(23);
        System.out.println("subSet: " + subset);

    }

    public static void main(String[] args) {
        hashSetDemo();

        //linkedHashSetDemo();

        //treeSetDemo();

        //treeSetDemo2();
    }
}

class Book  {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toString() {
        return "Title: " + title + " author: " + author + " year: " + year;
    }

    // hashCode()
    // When overriding the equals method we also need
    // to override the equals method
    /*public int hashCode() {
        return title.hashCode();
    }

    // equals()
    public boolean equals(Object o) {
        return (year == (((Book) o).getYear())) && (author == (((Book)o).getAuthor()));
    }*/


    // When overriding the equals method we also need
    // to override the equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author);
    }

    // Returns a hash code value for the object.
    // This method is supported for the benefit of hash tables such as those provided by java.util.HashMap.
    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

    /*Compares two strings lexicographically. The comparison is based on the Unicode value of each character in the strings.
    The character sequence represented by this String object is compared lexicographically to the character sequence represented by the argument string.
    The result is a negative integer if this String object lexicographically precedes the argument string.
    The result is a positive integer if this String object lexicographically follows the argument string. The result is zero if the strings are equal;
    compareTo returns 0 exactly when the equals(Object) method would return true.*/
  /*  public int compareTo(Object book) {
        return getTitle().compareTo(((Book) book).getTitle()); // utilizing String's compareTo
    }*/
}

class TitleComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        return ((Book) o1).getTitle().compareTo(((Book)o2).getTitle());
    }
}
