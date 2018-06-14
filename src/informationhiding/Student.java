package informationhiding;

public class Student {
    //variable declarations
    private int id;
    private String name;
    private String gender = "male";

    private static int student_count = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getStudent_count() {
        return student_count;
    }

    // Constructor
    public Student(int id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;

        // counting the students
        student_count++;
    }


    // method definition
    public boolean updateProfile(String name) {
        this.name = name;
        return true;
    }
}
