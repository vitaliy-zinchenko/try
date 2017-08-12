package test.nio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Vitalii Zinchenko
 */
public class IoSimpleClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost", 10100);
        OutputStream stream = socket.getOutputStream();
        String v1 = "test";

        System.out.println(v1.getBytes().length);

        stream.write(v1.getBytes());

        Thread.sleep(1000000000);
    }
}
