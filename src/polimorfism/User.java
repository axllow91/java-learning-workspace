package polimorfism;

public class User {

    public int id = 1;
    public String userType = "User";


    public User() {
        System.out.println("User constructor!");
    }

//     public void displayUserInfo() {
//         System.out.println("\nPrinting user info: ");
//         System.out.println("id: " + id); // here id is printing 1
//         System.out.println("userType: " + userType); // userType is reassign so it prints Staff
//     }

     public void printUserType() {
         System.out.println("User!");
     }

     public void saveWebLink() {
         System.out.println("User: saveWebLink");
         //postAReview();
     }

     public Review postAReview(String reviewText) {
         System.out.println("User: postAReview ");
         Review review = new Review(reviewText);
         // return the review text string
         return review;
     }

    // Method biding demo
    //
    public static void staticMethod() {
        System.out.println("User: staticMethod");
    }

    public void instanceMethod(double d) {
        System.out.println("User: instanceMethod");
    }

    public void instanceMethod(User u) {
        System.out.println("User: instanceMethod");
    }

    public final void finalMethod() { }

    // overriding the superclass Object toString method
    @Override
    public String toString() {
         return "\nPrinting User info: " + "\nid: " + id + "\nuserType: " + userType;
    }
}
