package GarbageCollector;

public class Hello {
    public static void main(String[] args) {
        Object hello = new Hello();
        hello.toString();
    }

    public String toString() {
        System.out.println("Hello");
        return "Hello!";
    }
}
