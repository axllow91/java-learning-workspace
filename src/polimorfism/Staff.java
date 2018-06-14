package polimorfism;

public class Staff extends User {
    // we are hiding the id from the user class
    // and if we want to access the id from the user class we need to call it with the super keyword
    public int id = 2;

    public Staff() {
        userType = "Staff";
        System.out.println("Staff: constructor 1");
    }

    // fast constructor
    public Staff(int id) {
        // invoke the default constructor which is an overloaded constructor
        this();
        // reassign the instance variable id to the param id
        this.id = id;
        System.out.println("Staff: constructor 2");

    }

    public void printId() {
        // printing the id directly
        System.out.println("id: " + id);
        System.out.println("super.id: " + super.id);
    }

    public void displayUserInfo() {
        System.out.println("\nPrinting user info: ");
        System.out.println("id: " + id); //here id = 2
        System.out.println("userType: " + userType); // here id = Staff
    }

    public void printUserType() {
        System.out.println("Staff");
    }

    //attempting to assign weaker access privileges ('private'); was 'public
     public Review postAReview(String textReview) {
        System.out.println("Staff: postAReview");
        // calling the supperclass method
        Review review = super.postAReview(textReview); // User: postAReview()
        review.setApproved(true);
        return review;
    }

    // needs to be the same param type to be an overriding method
    // example: public void instanceMethod(int d) {
    //    System.out.println("Staff: instanceMethod()"); }
    public void instanceMethod(int d) {
        System.out.println("Staff: instanceMethod()");
    }

    // needs to be the same param type to be an overriding method
    public void instanceMethod(Staff d) {
        System.out.println("Staff: instanceMethod()");
    }

    // !!we cannot override final methods.
    //public void finalMethod() {}
    public static void staticMethod() {
        System.out.println("Staff: staticMethod()");
    }
}
