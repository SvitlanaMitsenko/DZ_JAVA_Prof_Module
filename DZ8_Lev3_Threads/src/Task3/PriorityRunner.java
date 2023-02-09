package Task3;

public class PriorityRunner {
    public static void main(String[] args) {
        Thread th1 = new Thread(new PriorityThread(), "Мин. приоритет");
        th1.setPriority(Thread.MIN_PRIORITY);
        Thread th2 = new Thread(new PriorityThread(), "Макс. приоритет");
        th2.setPriority(Thread.MAX_PRIORITY);
        Thread th3 = new Thread(new PriorityThread(), "Норм. приоритет");
        th3.setPriority(Thread.NORM_PRIORITY);

        th1.start();
        th2.start();
        th3.start();
    }
}
class PriorityThread implements Runnable{

    @Override
    public void run() {
        for (int i=1; i<51; i++){
            System.out.println("i = " + i + " работает поток " + Thread.currentThread().getName());
        }
    }
}
