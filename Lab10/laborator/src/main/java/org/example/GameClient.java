package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GameClient
{
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args)
    {
        try
        {
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            String userInput;
            while ((userInput = in.readLine()) != null)
            {
                out.println(userInput);
                if (userInput.equals("exit")) {break;}
            }

            in.close();
            out.close();
            socket.close();
        }
        catch (IOException e) {e.printStackTrace();}
    }
}
