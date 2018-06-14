package nestedclasses;

import java.util.Arrays;


interface CacheIterator {
    boolean hasNext();
    Bookmark next();
}


class FooBar {
    protected int y = 0;

    FooBar(int x) {
        y = x;
    }
}

public class Cache {
    private Bookmark[] items;
    private int next = 0;

    // instance initializer
    // we cannot have a constructor
//    private static final Comparator<Bookmark> RATING_COMPARATOR = new Comparator<Bookmark>() {
//        {
//            System.out.println("instance initializer");
//        }
//
//        @Override
//        public int compare(Bookmark o1, Bookmark o2) {
//            return o1.getRating() < o2.getRating() ? 1 : -1;
//        }
//    };


    public Cache(int size) {
        items = new Bookmark[size];
    }

    // adding bookmark to the bookmark array
    private void add(Bookmark item) {
        if(next < items.length) {
            items[next++] = item;
        }
    }

    private CacheIterator iterator() {
        // return new MyCacheIterator();

        /*int count = 0;
        count++;*/

        // Instance variable "items" will be accessed via hidden reference
        // But, local variables such as "count" will be copied as inner class's instance variable.
        CacheIterator iterator = new CacheIterator() {

            private int i = 0;

            @Override
            public boolean hasNext() {
                // System.out.println(count);
                return i < items.length; // return true if i is less than the length of our array
            }

            // increment the index
            @Override
            public Bookmark next() {
                return items[i++];
            }
        };
        return iterator;
    }

   /* private class MyCacheIterator implements CacheIterator {
        private int i = 0;

        @Override
        public boolean hasNext() {
            return i < items.length; // return true if i is less than the length of our array
        }

        // increment the index
        @Override
        public Bookmark next() {
            return items[i++];
        }
    }*/

    public static void main(String[] args) {

        Cache recommendedItems = new Cache(5);

        Bookmark item1 = new Bookmark();
        item1.setId(2000);
        item1.setTitle("Use Final Liberally");
        item1.setRating(1.0);

        Bookmark item2 = new Bookmark();
        item2.setId(3000);
        item2.setTitle("Java Something");
        item2.setRating(3.0);

        Bookmark item3 = new Bookmark();
        item3.setId(4000);
        item3.setTitle("How you do?");
        item3.setRating(2.2);

        Bookmark item4 = new Bookmark();
        item4.setId(5000);
        item4.setTitle("Sarba?");
        item4.setRating(4.5);

        Bookmark item5 = new Bookmark();
        item5.setId(5000);
        item5.setTitle("Batman?");
        item5.setRating(5.0);

        recommendedItems.add(item1);
        recommendedItems.add(item2);
        recommendedItems.add(item3);
        recommendedItems.add(item4);
        recommendedItems.add(item5);


        //CacheIterator iterator = recommendedItems.new MyCacheIterator();
        CacheIterator iterator = recommendedItems.iterator();

        // while iterator has a next item (while true)
        while(iterator.hasNext()) {
            // print the next iterator
            System.out.println(iterator.next().getTitle());
        }

        // Sorting by rating
        System.out.println("\n***Sorted by rating***");
        iterator = recommendedItems.iterator();


        Arrays.sort(recommendedItems.items, new Bookmark.ComparatorList.StringLengthComparator());

        while(iterator.hasNext()) {
            // print the next iterator
            System.out.println( iterator.next().getTitle());
        }


        new FooBar(5) {
            void go() {
                System.out.println("\nPrinting y in FooBar.go(): " + y);
            }
        }.go(); // ->> here we are invoking the go method with the object from FooBar


    }
}
