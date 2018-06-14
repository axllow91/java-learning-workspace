package threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;



public class MeetUpEventSimulator {

    public static class MeetUpEvent {
        private String name;
        private AtomicInteger count = new AtomicInteger(1); // 1 for organizer

        private MeetUpEvent(String name) {
            this.name = name;
        }

        public void attending(int guestCount) {
            if(guestCount == 1) {
                // Atomically increments by one the current value.
                count.incrementAndGet();
            } else {
                // adds the given value to the atomic value (count = 1)
                // 4 + 1 = 5
                count.addAndGet(guestCount);
            }
        }

        public void noAttending(int guestCount) {
            if(guestCount == 1) {
                // Atomically decrements by one the current value.
                count.decrementAndGet();
            } else {
                boolean updated = false;

                while(!updated) {
                    int currentCount = count.get();
                    int newCount = currentCount - guestCount;
                    updated = count.compareAndSet(currentCount, newCount);
                }
            }
        }

        public int getCount() {
            return count.get();
        }

    }

    public static void main(String[] args) {
        MeetUpEvent jugCostesti = new MeetUpEvent("The Costesti Java User Group");

        Thread user1 = new Thread(new Runnable() {
            @Override
            public void run() {
                jugCostesti.attending(4);
                System.out.println(Thread.currentThread().getName() + " : " + jugCostesti.getCount());
            }
        });

        Thread user2 = new Thread(new Runnable() {
            @Override
            public void run() {
                jugCostesti.attending(3);
                System.out.println(Thread.currentThread().getName() + " : " + jugCostesti.getCount());
                jugCostesti.noAttending(3);
                System.out.println(Thread.currentThread().getName() + " : " + jugCostesti.getCount());
            }
        });

        Thread user3 = new Thread(new Runnable() {
            @Override
            public void run() {
                jugCostesti.attending(1);
                System.out.println(Thread.currentThread().getName() + " : " + jugCostesti.getCount());
            }
        });

        user1.setName("User1");
        user2.setName("User2");
        user3.setName("User3");

        user1.start();
        sleep(1);
        user2.start();
        sleep(2);
        user3.start();
        sleep(2);

        System.out.println("Total attending: " + jugCostesti.getCount());

    }

    private static void sleep(int i) {
        try {
            TimeUnit.SECONDS.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
