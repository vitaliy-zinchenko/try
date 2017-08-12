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
        Socket socket = new Socket("localhost", 60100);
        try (
                OutputStream outputStream = socket.getOutputStream();
                InputStream inputStream = socket.getInputStream()
        ) {
            String request = "m1";
            outputStream.write(request.getBytes());

            byte[] response = new byte[10];
            int read = inputStream.read(response);
            System.out.println("Response: " + new String(response));
        }


    }
}
