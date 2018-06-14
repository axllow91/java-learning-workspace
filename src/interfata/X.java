package interfata;

public class X extends AbstractA implements B, C, Cloneable {
//    @Override
//    public void foo() {
//        System.out.println("X: foo()");
//        System.out.println("VAL: " + B.VAL); // if we have more than 1 interface with the same field name then
//        // we need to call the interface name + dot operator then the field
//    }

    @Override
    public void foo() {
        System.out.println("From C to X: foo()");
    }

    public C clone() {
        try {
            return (C) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
