package polimorfism;

public class UserTest {
    public void printUserType(User u) {
        u.printUserType();
    }


    public void approveReview(Staff s) {
        //s.approveReview(); - compile error because JVM cannot find the method of the instance variable s from Staff
        if(s instanceof Editor) {
            ((Editor) s).approveReview();
        } else {
            System.out.println("Invalid object passed!!!");
        }
    }

    public static void main(String[] args) {
        // Part 1
        User user = new User(); // --> user obj ref
        User staff = new Staff(); // --> staff obj ref
        User editor  = new Editor(); // --> editor obj ref

        UserTest ut = new UserTest();
        ut.printUserType(user);
        ut.printUserType(staff);
        ut.printUserType(editor);

        // Part2
        // cannot find the approveReview method because JVM is looking into the reference type
        // and not into the object type
        //editor.approveReview();

        // JVM starts looking into the inheritance tree upwards until it finds the method
        editor.postAReview("something");
        editor.saveWebLink();

        //---------------
        UserTest ust = new UserTest();
        //Exception in thread "main" java.lang.ClassCastException if we test the the logic of casting (instanceof)
        //see if the instance object is the same with the instance of that class (Staff s = new Staff();)
        //ust.approveReview(new Staff());
        ust.approveReview(new Editor()); // true

        // calling the postreview method
        System.out.println("----Something----");
        staff.postAReview("You are in the postreview method!");

        System.out.println("We are casting the object staff because we cannot see the method in the staff class.");
        ((Staff) staff).printId();

        //-----------------------
        User staff1 = new Staff();
        User.staticMethod(); // part1
        staff1.postAReview("Something new");

        // The method call will be the method from the Userclass because the compiler are searching for the most
        // appropriate method so instanceMethod(double d) is the one compatible because the param
        // can be converted implicitly  valid conversion
        staff1.instanceMethod(10); // part 2

        // the method is called from the reference type (User)
        User staff2 = new Editor();
        User.staticMethod(); //early biding

        //Fields that are not overridden
        User newStaff = new Staff();
        ((Staff) newStaff).displayUserInfo();
        ((Staff) newStaff).printId();

        // invoking the toString method
        User anotherStaff = new Staff();
        // prints polimorfism.Staff@4554617c
        System.out.println(anotherStaff.toString());

        // printing the toString method
        User staff3 = new Staff();
        System.out.println(staff3);

        //printing the address with the help of hashcode method
        System.out.println(staff3.hashCode());
        User staff4 = new Staff();
        System.out.println(staff4.hashCode());

        staff4 = staff3;
        System.out.println("Same address: staff4 ->" + staff4.hashCode() + " = " + staff3.hashCode() + "<- staff3");


        // Constructor chaining --
        // we invoke the second constructor with the id param
        System.out.println("\nConstructor chaining");
        User staff5 = new Staff(3);
        System.out.println(staff5);
    }
}

