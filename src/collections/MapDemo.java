package collections;

import java.util.*;

public class MapDemo {

    private static void hasMapDemo() {

        System.out.println("\nInside hashMapDemo() ...");

        // The insertions order is not preserved(ord here
        Map<String, Integer> map1 = new HashMap<>();
        //Associates the specified value with the specified key in this map. If the map previously contained a mapping for the key, the old value is replaced.
        map1.put("John", 25);
        map1.put("Roger", 21);
        map1.put("Ana", null);

        System.out.println("map1: " + map1);

        map1.put("Ana", 22);

        System.out.println("map1: " + map1);

        // Returns true if this map contains a mapping for the specified key.
        System.out.println("Contains John? " + map1.containsKey("John"));

        System.out.println("Value of John? " + map1.get("John"));

        /*Returns a Set view of the keys contained in this map.
          The set is backed by the map, so changes to the map are reflected in the set, and vice-versa.
          If the map is modified while an iteration over the set is in progress (except through the iterator's own remove operation),
          the results of the iteration are undefined. The set supports element removal, which removes the corresponding mapping from the map,
          via the Iterator.remove, Set.remove, removeAll, retainAll, and clear operations.
          It does not support the add or addAll operations.*/
        System.out.println("\nIterating using keySet ...");
        Set<String> names = map1.keySet();

        for(String name : names) {
            System.out.println("Name: " + name + ", Age: " + map1.get(name));
        }

        // Iterating using entrySet. For that we need a set that contains an Map.Entry
        /*A map entry (key-value pair). The Map.entrySet method returns a collection-view of the map, whose elements are of this class.
         The only way to obtain a reference to a map entry is from the iterator of this collection-view.
         These Map.Entry objects are valid only for the duration of the iteration; more formally, the behavior of a map entry is
         undefined if the backing map has been modified after the entry was returned by the iterator, except through the setValue operation on the map entry*/
        System.out.println("\nIterating using entrySet ...");
        Set<Map.Entry<String,Integer>> mappings = map1.entrySet();

        for(Map.Entry<String, Integer> mapping : mappings) {
            System.out.println("Name: " + mapping.getKey() + ", Age: " + mapping.getValue());
        }

        // Removing
        names.remove("Ana");
        System.out.println("names: " + names);

        //
        Map<String, Map<String, Object>> userProfile = new HashMap<>();

        Map<String, Object> profile = new HashMap<>();
        profile.put("age", 25);
        profile.put("department", "CS");
        profile.put("city", "new york");

        userProfile.put("John", profile);

        profile.put("age", 29);
        profile.put("department", "CS");
        profile.put("city", "Las Kekas");

        userProfile.put("Mrn", profile);

        System.out.println("userProfile: " + userProfile);

        Map<String, Object> profile1 = userProfile.get("John");
        int age = (Integer) profile1.get("age");
        System.out.println("Age: " + age);

    }

    private static void treeMapDemo() {
        System.out.println("\nInside treeMapDemo() ....");

        TreeMap<String, Integer> map1 = new TreeMap<>();
        map1.put("John", 25);
        map1.put("Ion", 33);
        map1.put("Suleiman", 20);

        System.out.println("\nmap1: " + map1);

        System.out.println("\nIterating using entrySet: ");
        Set<Map.Entry<String, Integer>> mappings = map1.entrySet();
        for(Map.Entry mapping : mappings) {
            System.out.println("Name: " + mapping.getKey() + ", Age: " + mapping.getValue());
            if(mapping.getKey().equals("John"))
                mapping.setValue(44);
        }

        System.out.println("map1: " + map1);
        // Exception in thread "main" java.lang.UnsupportedOperationException: the particular entry does
        // not support setValue() (floorEntry)
        // map1.floorEntry("Ionica").setValue(31);
        System.out.println("\nMap1: " + map1);

    }


    private static void immutableKeysDemo() {
        System.out.println("\nInside immutableKeysDemo() ...");
        List<Integer> list = new ArrayList();
        list.add(1);

        Map<List<Integer>, Integer> map = new HashMap<>();
        map.put(list, 1);

        // hashcode overrides the list with the parameter 1 so it's different from the first hashcode (returns null)
        list.add(2);
        System.out.println("map: " + map.get(list));

        Student s = new Student(1, null);
        Map<Student, Integer> map2 = new HashMap<>();
        map2.put(s,1);

        s.setName("John");
        System.out.println("map2: " + map2.get(s));
    }


    private static void lruCacheTest() {
        System.out.println("\nInside lruCacheTest() ...");

        Map<String, String> lruCache = new LRUCache<>(16, 0.75f, true);
        lruCache.put("a", "A");
        lruCache.put("b", "B");
        lruCache.put("c", "C");

        System.out.println(lruCache);

        lruCache.get("a");
        lruCache.get("a");
        lruCache.get("a");
        System.out.println(lruCache);
        lruCache.get("b");
        System.out.println(lruCache);

        lruCache.put("d", "D");
        System.out.println(lruCache);
        lruCache.put("e", "E");
        System.out.println(lruCache);

    }


    public static void main(String[] args) {
        //hasMapDemo();
        //immutableKeysDemo();
        //lruCacheTest();
        treeMapDemo();

    }
}

class LRUCache<K, V> extends LinkedHashMap<K, V> {
    //private static final long serialVersionUID = -1148654245777338631L;
    private static final int MAX_ENTRIES = 3;

    public LRUCache(int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
    }

    // Invoked by put and putAll after inserting a new entry into the map
    public boolean removeEldestEntry(Map.Entry eldest) {
        return size() > MAX_ENTRIES;
        //return false; // same as normal linked hash map
    }
}


class Student {
    private int id;
    private String name;


    public Student(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return id + ": " + name;
    }
}
