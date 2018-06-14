package bitwiseoperators;

public class BasicDemo {


    // break label
    static void labeledBreak() {
        System.out.println("\nInside labeledBreak...");
        int num = 0;

        // i = 0 - loop in j 0...9
        // dupa ce se termina repetarea in for(j)
        // atunci revine la for(i) = 1
        // dupa reintra in j pana ajunge din nou la 9
        //  ---------"----------"
        outermost: for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                if(i == 5 && j == 5)
                    // daca conditia if s-a indeplinit atunci se iese
                    // din primul for(i)
                    break outermost; // outer break --
                num++; //
            }
        }
        System.out.println("Num: " + num);
    }

    // continue label
    static void labelContinue() {
        System.out.println("\nInside labeledContinue ...");
        int num = 0;

        outermost: for (int i = 0; i < 10; i ++) {
            for(int j = 0; j < 10; j++) {
                if (i == 5 && j == 5) {
                    continue outermost;
                }
                num++;
            }
        }

        System.out.println("Num: " + num);
    }


    static void bitwiseOperators() {
        System.out.println("\nInside bitwiseOperators ...");
        int x = 1;
        int y = 3;

        System.out.println("x & y: " + (x & y)); //
        System.out.println("x | y: " + (x | y));
        System.out.println("x ^ y: " + (x ^ y));
        System.out.println("~x: " + (~x));
        System.out.println("true & false: " + (true & false));

        char c1 = 'a'; // U+0061 --> 0110 0001
        char c2 = 'b'; // U+0062 --> 0110 0010

        System.out.println("c1 | c2: " + (c1 | c2)); // 0110 0011 --> 99 in decimal --> 64 + 32 + 2 + 1 = 64 + 35 = 99

        // Since bitwise work only on Integer types the following will not compile
        //double d1 = 3.14;
        //double d2 = 5.15;
        //System.out.println("d1 | d2: " + (d1 | d2));

    }


    public static void main(String[] args) {
        bitwiseOperators();
        labeledBreak();
        labelContinue();
    }



}
