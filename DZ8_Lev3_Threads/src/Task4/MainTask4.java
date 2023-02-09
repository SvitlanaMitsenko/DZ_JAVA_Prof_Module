package Task4;
public class MainTask4 {
    public static void main(String[] args) throws InterruptedException {
        int count = 7;
        Letter letter = new Letter();
        Thread writer = new Thread(new Writer(letter, count));
        Thread sender = new Thread(new Sender(letter, count));
        sender.start();
        writer.start();
    }
}

class Writer extends Thread {
    Letter letter;
    int count;

    Writer(Letter letter, int count) {
        this.letter = letter;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 1; i <= count; i++) {
            letter.write(i);
        }
    }
}

class Sender extends Thread {
    Letter letter;
    int count;
    Sender(Letter letter, int count) {
        this.letter = letter;
        this.count =  count;
    }

    @Override
    public void run() {
        for (int i = 1; i <= count; i++) {
            letter.send(i);
        }
    }
}

class Letter {
    boolean isWritten;

    synchronized void send(int numb) {
        if (!isWritten) {
            //если письмо не написано, ждём пока напишут
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        //если письмо написано, отправляем его
        System.out.println("Письмо " + numb + " отправлено");
        isWritten = false;
        notify();
    }

    synchronized void write(int numb) {
        if (isWritten) {
            //если письмо написано, ждём когда оно отправится
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        // если письмо не написано, пишем
        isWritten = true;
        System.out.println("Письмо " + numb + " написано");
        notify();
    }
}