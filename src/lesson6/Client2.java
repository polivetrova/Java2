package lesson6;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost",8081);
        Scanner scanner = new Scanner(System.in);
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        String inputString;
        do{
            inputString = scanner.nextLine();
            dataOutputStream.writeUTF(inputString);
            dataOutputStream.flush();
        } while(!"\\finish".equals(inputString));

        dataOutputStream.writeUTF("Client message");
        dataOutputStream.flush();
        socket.close();
    }
}
