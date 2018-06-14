package VariableCasting;

public class Casting {
    public static void main(String[] args) {

        float f1 = 3.133f;
        float f2 = 4.135f;

        // implicit casting
        go(f1,f2);

        // explicit casting
        double avg = (2 + 3) / 2; // 2.0 not 2.5
        System.out.println(avg); // = 2.0

        double average = (double) (2 + 3) / 2;
        System.out.println(average); // = 2.5

        // explicit casting - castare obligatorie facuta de programator
        long y = 52;
        int x = (int) y;

        // implicit casting - castare automata facuta de compilator
        y = x;

        // castare implicita char - int
        char charInt = 'A';
        int intInt = charInt;
        System.out.println(intInt);

        // Pierdere de informatie out-of-range
        byte b = (byte) 123456; // 64 maxim (maximum supported)
        System.out.println("losing data: " + b);

        // Trunchiere
        int trunchiere = (int) 0.99;
        System.out.println("Trunchiere: " + trunchiere);

        // byte to char -
        byte bByte = 65;
        charInt = (char) bByte; // conversie din byte in int iar apoi din int in char
        System.out.println(charInt);

        go(22.2, 23.44);

    }

    // casting implicit
    static void go(double d1, double d2) {
        System.out.println("1: " +d1 + ", " + "2: " + d2);
    }
}
