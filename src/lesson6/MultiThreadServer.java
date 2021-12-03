package lesson6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadServer {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8081);
            System.out.println("Server socket created");

            do {
                System.out.println("Waiting for a client...");

                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                new ClientSocketHandler(socket).start();

            } while (true);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
