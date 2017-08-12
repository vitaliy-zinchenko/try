package test.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Vitalii Zinchenko
 */
public class SocketServerTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket socket = new ServerSocket(8181);
        Socket s = socket.accept();

        InputStream is = s.getInputStream();
        int c;
        while((c = is.read()) != -1) {
            System.out.println((char)c);
            Thread.sleep(10);
        }
    }

}
