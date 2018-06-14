package assertions;

public class D {
    void test(int i) {
        assert i > 0 : "Invalid i in D.test";

        B b = new B();
        b.test(-1);
    }
}
