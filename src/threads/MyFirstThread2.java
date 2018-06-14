package threads;

// Here the task will be defined within the Thread class himself
// Thread class also implements Runnable implements
public class MyFirstThread2 extends Thread {
    public void run() {
        System.out.println("\nInside run ...");
        go();
    }

    private void go() {
        System.out.println("\nInside go ...");
        more();
    }

    private void more() {
        System.out.println("\nInside more ...");
    }

    public static void main(String[] args) {
        Thread thread = new MyFirstThread2();
        thread.start();

        System.out.println("\nInside main ...");
    }
}
