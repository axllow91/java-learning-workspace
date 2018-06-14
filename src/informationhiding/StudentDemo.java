package informationhiding;


public class StudentDemo {
    public static void main(String[] args) {
        int[] studentIds = new int[] {1001, 1002, 1003};


        // Creating first student object and setting its state
        Student student1 = new Student(studentIds[0], "joan", "male");
        student1.updateProfile("John");

        // Creating second student object and setting its state
        Student student2 = new Student(studentIds[1], "mitica", "male");

        // Creating third student object and setting its state
        Student student3 = new Student(studentIds[2], "valerica", "female");



        // print each students name
        System.out.println("Student1: " + student1.getName());
        System.out.println("Student2: " + student2.getName());
        System.out.println("Student3: " + student3.getName());

        System.out.println("Number of students created so far: " + Student.getStudent_count());

    }
}
