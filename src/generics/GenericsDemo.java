package generics;


import java.io.Serializable;
import java.util.*;

interface Container<T> {
    void set(T a);

    T get();
}

public class GenericsDemo<T> {

    // generic constructors are rare!!
    <E extends T> GenericsDemo(E object) {
    }
    // <E> GenericsDemo(E object) {}
    // GenericsDemo(T object) {}
    // <E extends T> GenericsDemo() {}


    public static void main(String[] args) {
        Container<String> stringStore = new Store<>();
        stringStore.set("Java");
        System.out.println(stringStore.get());

        Container<Integer> integerStore = new Store<>();
        integerStore.set(10);
        System.out.println(integerStore.get());


        Container<List<Integer>> listStore = new Store<>();
        listStore.set(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        System.out.println(listStore.get());


        // Type argument cannot be primitive
        // Container<int> intStore  = new Store();

        List<Number> list = new ArrayList<>();
        list.add(1); // list.add(new Integer(1));
        list.add(2.0); // list.add(new Double(2.0));
        // list.add(new String("22.0")); - error

        List[] array = new List[2];
        array[0] = new ArrayList();
        array[1] = new LinkedList();

        // doesnt give an error because arraylist is a subtype of both interfaces
        //GenericsDemo<ArrayList> list1 = new GenericsDemo<>();

        // Raw type demo
        // rawTypeTest();

        List<String> strList1 = Arrays.asList("a", "b", "c");
        List<String> strList2 = Arrays.asList("a", "c", "d");
        getCommonElementsCount(strList1, strList2);

        // Generic methods invocation
        genericMethodsDemo();

        // Bounded Wildcards
        boundedWildcards();
    }


    // Demonstrates
    // (a) Type argument inference via method arg & target type
    // (b) Explicit type argument specification
    // (c) Generic constructor
    // (d) aggregate method fix from wildcard demo
    static void genericMethodsDemo() {
        System.out.println("\n\nInside genericMethodsDemo() ...");

        // (a) Type argument inference via method arg & target type
        typeArgInference(22.0);
        typeArgInference("Java");

        // Compile-type  type-safety benefit in a generic method
        // Double doubleVal = typeInference1("2.0/Java"); -> error at compile time
        Double doubleVal = typeInference1(2.0);
        System.out.println(doubleVal);

        // Compile-time type-safety benefit in a generic method ~ wrong arguments
        Integer[] na = new Integer[100];
        Collection<Number> cs = new ArrayList<>(); // show with Number, String
        arrayToCollection(na, cs);


        // Showing with number
        Number[] ca = new Number[10];
        Collection<Number> numb = new ArrayList<>();
        arrayToCollection(ca, numb);

        // Showing with string
        String[] strings = new String[10];
        Collection<String> stringArrayList = new ArrayList<>();
        arrayToCollection(strings, stringArrayList);

        // Type argument inference via target type
        String strVal = typeArgInferenceFromTargetType1();

        // Compiler places implicit Integer cast. But, method returns string!!
        // Integer intVal = typeArgInferenceFromTargetType1();

        GenericsDemo.targetTypeInvoker1(typeArgInferenceFromTargetType2());
        GenericsDemo.targetTypeInvoker1(new ArrayList<>()); // String will be infer in the array list <>diamond
        GenericsDemo.targetTypeInvoker2(typeArgInferenceFromTargetType2()); // infers as object
        List<String> stringList1 = GenericsDemo.targetTypeInvoker2(typeArgInferenceFromTargetType2()); // infers as string
        GenericsDemo.targetTypeInvoker2(new ArrayList<>());
        List<String> stringList2 = GenericsDemo.targetTypeInvoker2(new ArrayList<>()); // Infers as string for both method and array list

        // Inferring most specific super-type
        Serializable obj = typeArgInference3("", new ArrayList<>()); // both infer as serializable obj because it's their super type
        AbstractCollection c = typeArgInference4(new ArrayList(), new HashSet()); // infers as abstract collection

        // so because the type param doesn't exist is useless
        GenericsDemo.<String>uselessGenericMethod(); // type witness

        // Explicit type argument specification: Type witness. Comment out generic constructor!!
        // GenericsDemo.<GenericsDemo>typeArgInference(new GenericsDemo());

        // Type arg for both constructor &  new expression inference:
        // (I) inferred from constructor argm. If that's not possible then
        // (II) context comes into play, ex: target type or method invocation content
        new GenericsDemo<Number>(12.0); // T is Number, E is Double
        new GenericsDemo<>(12.0); // T & E are double
        new <Double>GenericsDemo<Number>(12.0); // Type witness

        //
        List<Integer> intList1 = Arrays.asList(1, 2);
        List<Integer> intlist2 = Arrays.asList(3, 4);
        List<Integer> intlist3 = new ArrayList<>();
        aggregate(intList1, intlist2, intlist3);
        System.out.println(intlist3);

        // Invariance Workaround
        // error we invoke array list of string but we only can pass array list of number or a sub-type
        // GenericsDemo.invarianceWorkaround(new ArrayList<String>());
        List<Integer> intList4 = new ArrayList<>();
        GenericsDemo.invarianceWorkaround(intList4, 24);
        Integer data = intList4.get(0);
        System.out.println(data);


    }

    // Bounded Wildcards
    private static void boundedWildcards() {
        System.out.println("\n\nInside boundedWildcards() ...");

        List<Integer> intList = Arrays.asList(11, 22, 31);
        display(intList);
        List<Double> doubleList = Arrays.asList(11.5, 22.5, 31.5);
        display(doubleList);

        // Pass a List<String> will end up with an error because String is not a sub-type of Number
        List<Number> numList = new ArrayList<>();
        aggregateWithConsumer(intList, doubleList, numList);
        System.out.println("numList: " + numList);

        //
        Collections.addAll(new ArrayList<Object>(), 1, 2);
        /*
        * Copies all of the elements from one list into another.
        * After the operation, the index of each copied element in the destination list will be identical to its index in the source list.
        * The destination list must be at least as long as the source list.
        * If it is longer, the remaining elements in the destination list are unaffected.
        *  (it will copy into the list the values into the same indexes)
        * */
        Collections.copy(numList, doubleList);
        System.out.println("numList after copy: " + numList);
        // disjoint() --> Returns true if the two specified collections have no elements in common.
        System.out.println("Collections.disjoint: " + Collections.disjoint(intList, doubleList));

        // Type argument inference is Integer with wildcard type version of replaceAll
        GenericsDemo.replaceAll(numList, 11.5, 44);
        System.out.println("numList: " + numList);

        ArrayList<Number> numList2 = new ArrayList<>(intList); // so we can pass a Integer because is a sub-type of Number
        System.out.println(numList2);


    }

    // Demonstrates exact match as it both produces & consumes data
    private static <T> boolean replaceAll(List<T> list, T oldValue, T newValue) {
        for(int i = 0; i < list.size(); i++) {
            if(oldValue.equals(list.get(i))) { // here we are producing data
                // Replaces the element at the specified position in this list with the specified element (optional operation).
                list.set(i, newValue); // and here we are consuming data
            }
        }
        return true;
    }

    // Renaming the method to aggregate will lead to a compiler error due to type erasure
    // ex: l1 -> List<Integer> l2--> List<Double> both will be erased after the use.
    private static <E> List<? super E> aggregateWithConsumer(List<? extends E> l1,
                                                             List<? extends E> l2,
                                                             List<? super E> l3) {
        l3.addAll(l1); // consuming data
        l3.addAll(l2); // consuming data

        return l3;
    }


    // this is a productive type
    // Using a wildcard parameter
    private static void display(List<? extends Number> list) {
        for (Number element : list) {
            System.out.println("display()/element: " + element/*.intValue()*/); // -> invValue() will truncate the elements
        }
    }

    /*
    *  Using the generic method
    *   private static <T extends Number> void display(List<T> list) {
        for(Number element : list) {
            System.out.println("display()/element: " + element); // -> invValue() will truncate the elements
        }
    }
    * */


    private static <E> void aggregate(List<E> list1, List<E> list2, List<E> list3) {
        list3.addAll(list1);
        list3.addAll(list2);
    }

    // type param does not exist
    private static <T> void uselessGenericMethod() {
        T t = (T) new Integer(2);
        System.out.println("typeWitness: " + t.getClass().getName());
    }


    private static void targetTypeInvoker1(List<String> list) {
        for (String s : list) {
            System.out.println("Element: " + s);
        }
    }


    private static <T> List<T> targetTypeInvoker2(List<T> list) {
        return list;
    }

    private static <T> T typeArgInferenceFromTargetType1() {
        return (T) "abc";
    }

    private static <T> void arrayToCollection(T[] a, Collection<T> b) {
        for (T o : a) {
            b.add(o); // Correct
        }

    }

    // Type argument inference via method arg
    private static <T> void typeArgInference(T object) {
        System.out.println("Type argument: " + object.getClass().getName());
    }


    private static <T> T typeInference1(T object) {
        System.out.println("Type argument: " + object.getClass().getName());
        return object;
    }

    private static <T> T typeArgInference3(T object1, T object2) {
        System.out.println("Most specific type argument inferred: " + object2.getClass().getName());
        return object1;
    }

    private static <T> T typeArgInference4(T object1, T object2) {
        System.out.println("Most specific type argument inferred: " + object1.getClass().getName());
        return object2;
    }

    // Type argument inference via target type
    private static <T> List<T> typeArgInferenceFromTargetType2() {
        List<String> list = new ArrayList<>();
        list.add("abc");

        return (List<T>) list;
    }


   /* private void go(T list) {
        list.add(0, new Object());
    }
*/

    private static void rawTypeTest() {
        System.out.println("\n\nInside the rawTypeTest ...");
        int ISBN = 1505297729;
        List<Double> prices = new ArrayList<>();

        HalfIntegrator.getPrice(ISBN, prices);
        Double price = prices.get(0);
    }

    private static int getCommonElementsCount(List list1, List list2) {
        int count = 0;
        for (Object element : list1) {
            if (list2.contains(element)) {
                count++;
            }
        }

        System.out.println("common elements count: " + count);
        return count;
    }

    // invariance
    // Invariance workaround ~ For harmless scenarios where type safety is not a concern
    static <T extends Number> void invarianceWorkaround(List<T> list, T element) {

        // typically element of type T will be a Double
        // asting to T
        //T element = (T) new Double(2.30); we are not doing that !!
        list.add(element);
    }

}

class HalfIntegrator {

    public static void getPrice(int ISBN, List prices) {
        prices.add(45);
    }

}

class Store<T> implements Container<T> {
    // private static T a; -> compilation error
    private T a;

    public void set(T a) {
        this.a = a;
    }

    public T get() {
        return a;
    }
}
