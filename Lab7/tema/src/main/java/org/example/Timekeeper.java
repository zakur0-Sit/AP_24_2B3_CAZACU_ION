package org.example;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Timekeeper extends Thread {
    private final int timeLimit;
    private final List<Player> players;

    public Timekeeper(int timeLimit, List<Player> players) {
        this.timeLimit = timeLimit;
        this.players = players;
    }

    @Override
    public void run() {
        Timer timer = new Timer(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time's up!");
                stopPlayers();
                calculateMaxSequenceLength();
            }
        }, timeLimit * 1000L);

        while (true) {
            // Firul timekeeper rulează până când timpul se scurge
        }
    }

    private void stopPlayers() {
        for (Player player : players) {
            player.interrupt();
        }
    }

    private void calculateMaxSequenceLength() {
        int maxSequenceLength = 0;
        for (Player player : players) {
            int sequenceLength = player.getSequenceLength();
            if (sequenceLength > maxSequenceLength) {
                maxSequenceLength = sequenceLength;
            }
        }
    }
}
