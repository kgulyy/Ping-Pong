package solution.first;

public class PingPongThread extends Thread {
    public static final Object lock = new Object();
    private String msg;

    public PingPongThread(String msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                System.out.println(msg);

                lock.notifyAll();

                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}