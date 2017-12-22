package solution.first;

public class Main {
    public static void main(String[] args) {
        final PingPongThread pingThread = new PingPongThread("PING");
        final PingPongThread pongThread = new PingPongThread("pong");
        pingThread.start();
        pongThread.start();
    }
}
