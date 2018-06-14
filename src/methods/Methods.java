package methods;

public class Methods {

    static void go(int[] array) {
        System.out.println("Array[0]: " + array[0] + "\narray[1]: " + array[1]);

        // pass by value
        array[1] = 22;
    }

    static void go(int i) {
        System.out.println("go(int i): " + i);
    }

    static void go(short i) {
        System.out.println("go(short i): " + i);
    }

    static void varargsOverload(boolean b, int i, int j , int  k) {
        System.out.println("\nInside varargsOverload without varargs");
    }

    // varargs methods
    static void varargsOverload(boolean b, int... list) {
        System.out.println("\nInside varargsOverload with varargs...");
        System.out.println("list.length = " + list.length);
    }


    public static void main(String[] args) {
        int[] array = {1, 2};

        go(array);

        // calling the update value
        System.out.println("\narray[1]: " + array[1]);

        byte b = 22;

        go(b);

        //
        varargsOverload(true, 1, 2, 3);
        varargsOverload(false, 1, 2, 3, 4, 5, 6, 7, 8, 9); //
        // can be omitted!
        varargsOverload(true);

    }
}
