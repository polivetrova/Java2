package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8081);
            System.out.println("Server socket created");
            System.out.println("Waiting for a client...");

            Socket socket = serverSocket.accept();
    //        socket.getInputStream(); плохо и  долго и по байтам
    //        socket.getOutputStream();  вместо этого датаинпутстрим
            System.out.println("Client connected");
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            String messageFromClient;
            do {
                messageFromClient = dataInputStream.readUTF();
                System.out.println("Echo: " + messageFromClient);
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataOutputStream.writeUTF("Message from server");
            } while(!"\\finish".equals(messageFromClient));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
