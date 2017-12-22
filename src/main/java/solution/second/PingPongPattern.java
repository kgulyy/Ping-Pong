package solution.second;

import java.util.concurrent.SynchronousQueue;

public class PingPongPattern {
    private SynchronousQueue<Integer> queue = new SynchronousQueue<>();

    private Thread t1 = new Thread() {
        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("PING");
                    queue.put(1);
                    queue.put(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    };

    private Thread t2 = new Thread() {
        @Override
        public void run() {
            while (true) {
                try {
                    queue.take();
                    System.out.println("pong");
                    queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }

    };

    public static void main(String[] args) {
        final PingPongPattern pingPongPattern = new PingPongPattern();
        pingPongPattern.t1.start();
        pingPongPattern.t2.start();
    }
}