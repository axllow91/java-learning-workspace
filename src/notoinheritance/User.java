package notoinheritance;

// final -- cannot extends the class
// cannot have subclasses
public class User {
    public int id;

    private User() { }

    private User(int id) {
            System.out.println("User: constructor");
            this.id = id;
    }

    public String toString() {
        return "\nId: " + id;
    }

    final static double math(double d) {
        return Math.pow(d, 2);
    }

}
