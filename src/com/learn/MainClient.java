package com.learn;

import Server.MainServer;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

class ClientThread extends Thread{
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private static int counter = 0;
    private final int id = counter++;
    private static int threadcount = 0;
    public static int threadCount() {
        return threadcount;
    }
    public ClientThread(InetAddress addr) {
        System.out.println("Making client " + id);
        threadcount++;
        try {
            socket = new Socket(addr, MainServer.Port);
        } catch(IOException e) {
            System.err.println("Socket failed");
        }
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            start();
        } catch(IOException e) {
            try {
                socket.close();
            } catch(IOException e2) {
                System.err.println("Socket not closed");
            }
        }
    }
    public void run() {
        Id id = new Id("0926465279", "2350343", "ALi Mohammad Tabatabaei", "09039856420");
        //SavingAccount savingAccount = new SavingAccount(101,id, 0, "now", new Scanner(System.in).next());
        try {
            out.println(id.toString());
            System.out.println(in.readLine());
            out.println("END");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch(IOException e) {
                System.err.println("Socket not closed");
            }
            threadcount--;
        }
    }

}
public class MainClient {
    static final int MAX_THREADS = 10;
    public static void main(String[] args) throws IOException, InterruptedException {
        InetAddress addr = InetAddress.getByName(null);
        //while(true) {
            if(ClientThread.threadCount() < MAX_THREADS)
                new ClientThread(addr);
            Thread.sleep(100);
      //  }
    }
}
