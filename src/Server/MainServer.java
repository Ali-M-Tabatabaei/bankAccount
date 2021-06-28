package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class SingleServer extends Thread{
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public SingleServer(Socket s) throws IOException {
        socket = s;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        start(); // Calls run()

    }
    public void run() {
        try {
            while (true) {
                String str = in.readLine();
                if (str.equals("END"))
                    break;
                File file = new File("E:\\daneshga\\projects\\projectjava\\github\\bankAccount\\src\\Server\\DataBase.txt");
                try (PrintStream outputStream = new PrintStream(new FileOutputStream(file));
                     Scanner inputStream = new Scanner(file))
                {
                    outputStream.println(str);
                    System.out.println(inputStream.nextLine());
                    out.println("done");
                }

            }
            System.out.println("closing...");
        } catch(IOException e) {
            System.err.println("IO Exception");
        } finally {
            try {
                socket.close();
            } catch(IOException e) {
                System.err.println("Socket not closed");
            }
        }
    }
}
public class MainServer {
    public final static int Port= 9080;

    public static void main(String[] args) {
        ServerSocket s = null;
        try {
            s = new ServerSocket(Port);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Server Started");
            try {
                while(true) {
                    Socket socket = s.accept();
                    try {
                        new SingleServer(socket);
                    } catch(IOException e) {
                        socket.close();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }

}
