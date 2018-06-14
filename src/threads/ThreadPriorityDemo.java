package threads;

public class ThreadPriorityDemo {

    public static void main(String[] args) {

        // Returns a reference to the currently executing thread object.
        System.out.println(Thread.currentThread());

        Thread t1 = new Thread(new EmailCampaign());
        Thread t2 = new Thread(new DataAggregator());

        t1.setName("EmailCampaign");
        t2.setName("DataAggregator");

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();

        try {
            /*
            * public final void join()
               throws InterruptedException
            * Waits for this thread to die.
            * An invocation of this method behaves in exactly the same way as the invocation
            * */
            // main thread is suspended until t2 DIES
            t2.join();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nInside main ...");
    }
}

class EmailCampaign implements Runnable {
    @Override
    public void run() {
        System.out.println("\n***EmailCampaign***");
        for(int i = 1; i <= 10; i++) {
            System.out.println(i + " - " +Thread.currentThread().getName());
            if(i == 5) {
                // Hint to scheduler that thread is willing to
                // yield its current use of CPU
                Thread.yield();
            }
        }
    }
}


class DataAggregator implements Runnable {

    @Override
    public void run() {
        System.out.println("\n***DataAggregator***");
        for(int i = 1; i <= 10; i++) {
            System.out.println(i + " - " + Thread.currentThread().getName());
        }
    }
}

