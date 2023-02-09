package Task2;

public class MainTask2 {
    public static void main(String[] args) throws InterruptedException{
        Thread th1 = new Thread(new MyThread(0), "First");
        Thread th2 = new Thread(new MyThread(1000), "Second");
        Thread th3 = new Thread(new MyThread(3000), "Third");

        th1.start();
        th2.start();
        th3.start();

        Thread.sleep(3050);
        System.out.println("Поток "  + Thread.currentThread().getName() + " завершил работу");
    }
}
class MyThread extends Thread {
    long delay;
    MyThread(long delay){
        this.delay = delay;
    }

    @Override
    public void run() {
        try {
            sleep(delay);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Поток "  + currentThread().getName() + " завершил работу");
    }
}
