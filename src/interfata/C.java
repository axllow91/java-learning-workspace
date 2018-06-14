package interfata;

public interface C extends A {
    void foo();
    default void go() {
        System.out.println("C: go");
    }

    static void staticMethod() {
        System.out.println("C: staticMethod");
    }
}
