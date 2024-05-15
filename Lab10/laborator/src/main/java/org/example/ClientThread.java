package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread
{
    private Socket clientSocket;

    public ClientThread(Socket clientSocket) {this.clientSocket = clientSocket;}

    @Override
    public void run()
    {
        try
        {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null)
            {
                System.out.println("Server received the request: " + inputLine);
                if (inputLine.equals("stop"))
                {
                    out.println("Server stopped");
                    break;
                }
                else {out.println("Server received the request: " + inputLine);}
            }

            in.close();
            out.close();
            clientSocket.close();
        }
        catch (IOException e) {e.printStackTrace();}
    }
}
