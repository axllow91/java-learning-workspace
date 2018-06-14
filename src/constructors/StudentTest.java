package constructors;

public class StudentTest {
    public static void main(String[] args) {
        Student s = new Student();

        s.id = 1000;
        s.name = "joan";
        s.gender = "male";

        s.updateProfile("Ioan");

        System.out.println(s);

        Student s1 = new Student(1001, "Bogdana", "Female");
        System.out.println("\n" + s1);

        Student s2 = s1;
        System.out.println("---------------------------------------------------------");
        System.out.println("O copie a obiectului s1 va fi atribuit lui s2. Deci, s1 si s2 au aceeasi adresa in mem");
        System.out.println(s2);

        //s2 = new Student("Mitica");

        System.out.println(s1.equals(s2)); // true daca s2 = s1 false daca s2 = new Student("asdf");
        s1 = s2; // lui s1 atribuim adresa lui s2, deci si rezultatul
        System.out.println(s1);
    }
}
