package test.nio.channels;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Vitalii Zinchenko
 */
public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Creating socket");
        Socket socket = new Socket("localhost", 60100);
        System.out.println("Socket created.");
        try (
                OutputStream outputStream = socket.getOutputStream();
                InputStream inputStream = socket.getInputStream()
        ) {
            System.out.println("Sending request.");
            String request = "m1";
            outputStream.write(request.getBytes());

//            System.out.println("Retrieving response");
//            byte[] response = new byte[10];
//            int read = inputStream.read(response);
//            System.out.println("Response: " + new String(response));
        }


    }
}
