package com.pubuduranasinghe.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Pubudu on 2017-06-18.
 */
public class GameClient {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private static int PORT = 8901;

    public GameClient(String serverAddress) throws Exception {
        socket = new Socket(serverAddress, PORT);
        in = new BufferedReader(new InputStreamReader(
                socket.getInputStream()
        ));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("GameClient Running..");
        while(true) {
            String serverAddress = (args.length == 0) ? "localhost" : args[1];
            GameClient client = new GameClient(serverAddress);
            client.play();
        }
    }

    private void play() throws Exception {
        String response;
        try {
            response = in.readLine();
            if(response.startsWith("WELCOME")) {
                System.out.println(response.substring(8));
            }
        } finally {
            socket.close();
        }
    }

}
