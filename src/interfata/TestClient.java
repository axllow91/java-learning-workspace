package interfata;


public class TestClient {
    public static int getVal() {
        return 42;
    }

    public static void main(String[] args) {
        A a = new X();
        a.foo();
        a.bar();


        C c = new X();
        System.out.printf("\nc instanceof X: %s", c instanceof X);


        C clone = ((X)c).clone();
        System.out.printf("\nclone instanceof X: %s", clone instanceof X);
        System.out.printf("\nclone instanceof Object: %s", clone instanceof Object);
        if(clone != c) {
            System.out.println("\nClone created!!");
        }

        //
        C c1 = new X();
        c1.go();

        new TestClient().lambdaTest(() -> System.out.println("Java Rocks"));

        C.staticMethod();
    }

    void lambdaTest(FunctionalInterface fi) {
        fi.test();
    }


}
