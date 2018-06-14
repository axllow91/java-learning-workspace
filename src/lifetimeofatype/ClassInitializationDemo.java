package lifetimeofatype;

interface Superinterface {
    int STATIC_FINAL3 = new ClassInitializationDemo().getInt();
    int STATIC_FINAL5 = new ClassInitializationDemo().getInt5();
    static void staticMethod() {
        System.out.println("Superinterface: staticMethod");
    }
}

class ObjectReference {
    ObjectReference() {
        System.out.println("ObjectReference: constructor");
    }
}

class SuperClass {
    static {
        System.out.println("Superclass: static initializer");
    }
    {
        System.out.println("Superclass: instance initializer");
    }
    SuperClass() {
        System.out.println("Superclass: constructor");
    }
}

class SubClass extends SuperClass implements Superinterface {
    static final int STATIC_FINAL = 47;
    static final int STATIC_FINAL2 = (int) (Math.random() * 5);

    ObjectReference objectReference = new ObjectReference();

    static {
        System.out.println("Subclass: static initializer");
        //staticFinal = 47;
    }

    SubClass() {
        System.out.println("Subclass: constructor");
    }
    // Instance initializer is copied to the beginning of constructor by compiler
    {
        System.out.println("Subclass: instance initializer");
    }
}


public class ClassInitializationDemo {
    // it will not be executed if(because) an instance of ClassInitializationDemo has not been created in the main method
    {
        System.out.println("\nClassInitializationDemo: instance initializer");
    }

    static {
        System.out.println("\nClassInitializationDemo: static initializer (Initialization Stage)");
    }

    static int getInt(){
        System.out.println("ClassInitializationDemo: getInt()");
        return 3;
    }

    static int getInt5() {
        System.out.println("ClassInitializationDemo: getInt5()");
        return 5;
    }

    public static void main(String[] args) {

        System.out.println("\nJVM invoked in main method...");
        //ClassInitializationDemo classInitializationDemo = new ClassInitializationDemo();
        // Because STATIC_FINAL is a compile time constant and will not load the SubClass, so the value has got copied here
        System.out.println("Subclass.STATIC_FINAL: "  + SubClass.STATIC_FINAL);
        //System.out.println("Subclass.stringLiteral: " + SubClass.stringLiteral);
        System.out.println("Invoking Subclass.STATIC_FINAL2 ...");
        // SubClass is loaded because the STATIC_FINAL2 is not a compile time constant ( it's assigned with the help of
        // a random value by invoking a random function)
        // So SubClass has loaded and because of this the SuperClass has loaded and the Superinterface has loaded too
        // so the order will be Superinterface first, Superclass second and SubClass last
        System.out.println("Subclass.STATIC_FINAL2: " + SubClass.STATIC_FINAL2);
        // So we need to load this SubClass but this is already loaded in the HEAP so it's not going to be LOADED again
        // The ClassLoader will simply use the corresponding object which is already in the HEAP for that class
        // The SuperClass constructor will be first invoked
        new SubClass();

        System.out.println("Superinterface.STATIC_FINAL3: " + Superinterface.STATIC_FINAL3);

        Superinterface.staticMethod();
    }
}
