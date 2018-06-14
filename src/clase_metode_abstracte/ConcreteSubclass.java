package clase_metode_abstracte;

public class ConcreteSubclass extends AbstractSubclass {

    @Override
    void test1() {
        System.out.println("test1(): in concrete class");
    }

    void test1(String s) {
        System.out.println(s + " World");
    }

    @Override
    void test2() {
        System.out.println("test2(): in concrete class");
    }

    @Override
    void test3() {
        System.out.println("test3(): in concrete class");
    }



    public static void main(String[] args) {
        ConcreteSubclass concrete = new ConcreteSubclass();
        concrete.test1();
        concrete.test1("Suka");
        concrete.test2();
        concrete.test3();

        // abstract super class cannot be instantiated
        //AbstractSuperClass superClass = new AbstractSuperClass();
    }
}
