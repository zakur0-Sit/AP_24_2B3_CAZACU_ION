package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer
{
    private ServerSocket serverSocket;

    public GameServer(int port)
    {
        try
        {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);
        }
        catch (IOException e) {e.printStackTrace();}
    }

    public void start()
    {
        while (true)
        {
            try
            {
                System.out.println("Waiting for a client...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());
                ClientThread clientThread = new ClientThread(clientSocket);
                clientThread.start();
            }
            catch (IOException e) {e.printStackTrace();}
        }
    }

    public static void main(String[] args)
    {
        GameServer gameServer = new GameServer(12345);
        gameServer.start();
    }
}
