package threads;

public class RaceConditionDemo {
    public static void main(String[] args) {
        BankAccount task = new BankAccount();
        task.setBalance(100);

        Thread john = new Thread(task);
        Thread ana = new Thread(task);

        john.setName("John");
        ana.setName("Ana");

        john.start();
        ana.start();
    }
}

class BankAccount implements Runnable {
    private int balance;

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public void run() {
        makeWithdrawal(75);
        if(balance < 0) {
            System.out.println("Money overdrawn!!!");
        }
    }

    private synchronized void makeWithdrawal(int amount) {
        if(balance >= amount) {
            System.out.println(Thread.currentThread().getName() + "You withdraw: " + amount);
            balance -= amount;
        } else {
            System.out.println(Thread.currentThread().getName() + ", you can't withdraw. Balance too low!\nBalance: " + balance);
        }
    }

}