package threads;


import java.util.concurrent.TimeUnit;

// First way to launch a thread
// Fast approach - the one that is recommended to program
public class MyFirstThread {

    public static void main(String[] args) {
        Task task = new Task();
        // Thread - represents the worker
        // task - represents the task
        Thread thread = new Thread(task); // NEW state
        thread.start(); // Runnable state - ready to run (remember is not running)

        /*
        * public static void sleep(long millis)
                 throws InterruptedException
        * Causes the currently executing thread to sleep (temporarily cease execution) for the specified number of milliseconds,
        * subject to the precision and accuracy of system timers and schedulers.
        * The thread does not lose ownership of any monitors.
        * */
        try {
            //Thread.sleep(3000); // 3 sec
            // another way to do it
            TimeUnit.SECONDS.sleep(3);
            /*
            * public void interrupt()
            * Interrupts this thread.
            * Unless the current thread is interrupting itself, which is always permitted,
            * the checkAccess method of this thread is invoked, which may cause a SecurityException to be thrown.
            *
            * */
            thread.interrupt();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nInside main ...");
    }

}

class Task implements Runnable {
    private void go() {
        System.out.println("\nInside go ...");
        try {
            //Thread.sleep(9000); // 9 sec
            // another way to do it
            TimeUnit.SECONDS.sleep(9);
        }catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        more();
    }

    private void more() {
        System.out.println("\nInside more ...");
    }

    @Override
    public void run() {
        System.out.println("\nInside run ...");
        go();
    }

}



