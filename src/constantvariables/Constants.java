package constantvariables;

public class Constants {

    // final byte month2 = 2; - we cannot access instance variables so we need to make it static(class variable)
    static final byte month2 = 2;

    static void switchExample() {
        System.out.println("\nInside switchExample...");

        byte month = 3;
        switch (month) {
            case 1:
                System.out.println("January");
                break;
            case month2:
                System.out.println("February");
                break;
            case 3:
                System.out.println("March");
                break;
            default:
                System.out.println("April Fools");

        }
    }

    static void veryExpensive() {
        System.out.println("\nInside veryExpensive()...");

        //Long sum = 0L; - weak in performance
        long sum = 0L;
        for(long i = 0; i < Integer.MAX_VALUE; i++) {
            //sum = sum + i;
            sum += i;
        }
    }

    public static void main(String[] args) {
        switchExample();

        long start = System.nanoTime();
        veryExpensive();
        System.out.println("Elapsed time: " + ((System.nanoTime() - start)/ 1000000.0) + " mse");

    }
}
