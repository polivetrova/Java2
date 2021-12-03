package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost",8081);
        Scanner scanner = new Scanner(System.in);
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        String clientMessage;
        do{
            clientMessage = scanner.nextLine();
            dataOutputStream.writeUTF(clientMessage);
            dataOutputStream.flush();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            String messageFromServer = dataInputStream.readUTF();
            System.out.println("Message from server: " + messageFromServer);
        } while(!"\\finish".equals(clientMessage));
        socket.close();
    }
}
