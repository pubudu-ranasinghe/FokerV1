package com.pubuduranasinghe.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws Exception {
        ServerSocket listener = new ServerSocket(8901);
        System.out.println("GameServer is running..");
        try {
            while (true) {
                Socket socket = listener.accept();
                BufferedReader input = new BufferedReader(
                        new InputStreamReader(socket.getInputStream())
                );
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                output.println("WELCOME " + "HELLO CLIENT!!");
            }
        } finally {
            listener.close();
        }
    }
}
