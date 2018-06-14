package constructors;

public class Users {
    private int id;
    private String name;
    private int salary;

    Users(int userId, String userName) {
        id = userId;
        name = userName;
    }

    Users(int userId, String userName, int sal) {
        this(userId, userName); // getting rid of the duplicate code - duplicate code is bad
        salary = sal;
    }

    int idid;

    public String toString() {

        return ("\nID: " + id + "\nName: " + name + "\nSalary: " + salary);

    }


    public static void main(String[] args) {
        Users student = new Users(1011, "John");
        Users teacher = new Users(1012, "Michael", 20000);

        System.out.println(student);
        System.out.println(teacher);

        // int i = this.idid; // eroare la compilare nu poate fi folosit intr-o metoda statica
    }
}
