package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main
{
    public static void main(String[] args) throws InterruptedException {

        int tokenMaxValue = 5;
        int playersNumber = 4;
        int maxSequenceLength = 0;
        Bag bag = new Bag(tokenMaxValue);
        Map<String, Integer> allPlayersSequenceLength = new TreeMap<>();

        List<Player> players = new ArrayList<>();
        for(int i = 1; i <= playersNumber; i++)
        {
            players.add(new Player("Player-" + i, bag));
        }

        int timeLimit = 5; // Limita de timp în secunde
        Timekeeper timekeeper = new Timekeeper(timeLimit, players);
        timekeeper.start();

        for (Player player : players) {
            player.start();
        }

        for (Player player : players) {
            player.join();
        }

        for (Player player : players) {
            System.out.println("\n-------------------\n");
            player.showTokensList();
            System.out.println("\n-------------------\n");
            player.gameLogic();
            System.out.println("\n-------------------\n");
            int sequenceLength = player.getSequenceLength();
            allPlayersSequenceLength.put(player.name, sequenceLength);
            if (sequenceLength > maxSequenceLength)
                maxSequenceLength = sequenceLength;
        }

        for (Map.Entry<String, Integer> entry : allPlayersSequenceLength.entrySet())
            System.out.println(entry.getKey() + ": " + entry.getValue());

        System.out.println("\n\nPlayer(s) with the longest sequence:");
        for (Map.Entry<String, Integer> entry : allPlayersSequenceLength.entrySet()) {
            if (entry.getValue() == maxSequenceLength) {
                System.out.println(entry.getKey() + " WIN!: " + entry.getValue());
            }
        }

        System.out.println("Game over!");
    }
}