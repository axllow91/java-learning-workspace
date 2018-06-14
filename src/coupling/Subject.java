package coupling;


// Tight coupling
public class Subject{
    Topic t = new Topic();

    public void startReading() {
        t.understand();
    }

    public static void main(String args[]) {
        Subject s = new Subject();
        s.startReading();
    }
}

class Topic {
    public void understand() {
        System.out.println("Tight coupling concept!");
    }
}
