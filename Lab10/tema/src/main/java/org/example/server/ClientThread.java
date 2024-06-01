package org.example.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {

    private static int threadCount = 0;
    private Socket socket;

    private Player player;

    private static Battleship game;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public void timeUp() {
        if (TimeControl.isTimeUp()) {
            try {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println("Time's up! The game is over!");
                if (game != null) {
                    try {
                        game.removePlayer(this.player);
                    } catch (InterruptedException e) {
                        out.println("Failed to remove the player");
                    }
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void run() {
        System.out.println("Client connected");
        this.player = new Player("Player" + (++threadCount));
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            String request;
            String response = "Server received the request: ";
            while ((request = in.readLine()) != null) {
                if (request.equals("stop")) {
                    out.println("Server stopped");
                    break;
                } else if (request.equals("create game")) {
                    out.println(response + request);
                    if (game == null) {
                        game = new Battleship();
                        out.println("Game created");
                    } else {
                        out.println("A game already exists");
                    }
                } else if (request.equals("join game")) {
                    out.println(response + request);
                    if (game != null) {
                        try {
                            game.addPlayer(this.player);
                            out.println(this.player);
                            Thread timeControl = new Thread(new TimeControl(10000, this));
                            timeControl.setDaemon(true);
                            timeControl.start();
                        } catch (InterruptedException e) {
                            out.println("Failed to join the game");
                        }
                    } else {
                        out.println("A game must be created first");
                    }
                } else if (request.startsWith("submit move")) {
                    String[] parts = request.split(" ");
                    if (parts.length == 3) {
                        try {
                            int x = Integer.parseInt(parts[1]);
                            int y = Integer.parseInt(parts[2]);
                            String result = game.attack(this.player, x, y);
                            out.println(result);
                            if (game.isGameOver()) {
                                out.println("Game over!");
                                break;
                            }
                        } catch (NumberFormatException e) {
                            out.println("Invalid move format. Coordinates must be integers.");
                        }
                    } else {
                        out.println("Invalid move format. Use: submit move x y");
                    }
                } else {
                    out.println("Command " + request + " does not exist!");
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }


}
