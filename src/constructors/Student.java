package constructors;

public class Student {
    // variable declaration
    int id;
    String name;
    String gender;

    // default constructor
    Student() {}

    Student(String name) {
        this.name = name;
    }

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    Student(int id, String name, String gender) {
        this(id, name);
        this.gender = gender;
    }

    String updateProfile(String newName) {
        String oldName = this.name;  // temp var
        name = newName; //
        return oldName;
    }

    public String toString() {
        return "ID: " + id + "\nName: " + name + "\nGender: " + gender;
    }
}
