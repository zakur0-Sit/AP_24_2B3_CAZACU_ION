package org.example.server;

public class TimeControl implements Runnable{
    private final long timeLimit;
    private static volatile boolean timeUp = false;

    private final ClientThread clientThread;

    public TimeControl(long timeLimit, ClientThread clientThread) {
        this.timeLimit = timeLimit;
        this.clientThread = clientThread;
    }

    public synchronized static boolean isTimeUp() {
        return timeUp;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        while (true) {
            long elapsedTime = System.currentTimeMillis() - startTime;
            if (elapsedTime > timeLimit) {
                timeUp = true;
                System.out.println("Time's up! " + elapsedTime / 1000 + " seconds have passed!");
                clientThread.timeUp();
                break;
            }
        }
    }
}
