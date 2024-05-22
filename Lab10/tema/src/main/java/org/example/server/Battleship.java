package org.example.server;

import java.util.ArrayList;
import java.util.List;

public class Battleship {

    private List<Player> players = new ArrayList<>();

    public synchronized void addPlayer(Player player) throws InterruptedException {
        players.add(player);
    }

    public synchronized void removePlayer(Player player) throws InterruptedException {
        players.remove(player);
    }

    public synchronized String attack(Player attacker, int x, int y) {
        Player opponent = players.stream().filter(p -> !p.equals(attacker)).findFirst().orElse(null);
        if (opponent == null) {
            return "No opponent found!";
        }

        if (x < 0 || x >= 10 || y < 0 || y >= 10) {
            return "Invalid coordinates!";
        }

        int[][] opponentFleet = opponent.getFleetMatrix();
        if (opponentFleet[x][y] == 1) {
            opponentFleet[x][y] = -1;  // Mark as hit
            return "Hit!";
        } else {
            opponentFleet[x][y] = -2;  // Mark as miss
            return "Miss!";
        }
    }

    public synchronized boolean isGameOver() {
        return players.stream().anyMatch(player -> isPlayerDefeated(player));
    }

    private boolean isPlayerDefeated(Player player) {
        for (int[] row : player.getFleetMatrix()) {
            for (int cell : row) {
                if (cell == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
