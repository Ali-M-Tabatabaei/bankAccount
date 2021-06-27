package com.learn;

import Server.MainServer;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainClient {

    public static void main(String[] args) throws IOException {
        InetAddress address = InetAddress.getByName(null);
        Socket socket=  new Socket(address, MainServer.Port);


    }
}
