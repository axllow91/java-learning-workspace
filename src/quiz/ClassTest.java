package quiz;

public class ClassTest {
    public static void main(String[] args) {
        int x = 3, y = 4;
        switch (x + 3) {
            case 6:
                System.out.println("case 6: " + y);
                y = 0;
                System.out.println(x);
                System.out.println("End of case 6: " + y);
            case 7:
                System.out.println("case 7: " + y);
                y = 1;
                System.out.println("End of case 7: " + y);
            default :
                System.out.println("default: " + y);
                y += 1;
                System.out.println("End of default: " + y);
        }
        System.out.println(y);
    }
}
