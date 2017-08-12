package test.nio.nio2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by Vitalii Zinchenko
 */
public class Client2 {

    final static int DEFAULT_PORT = 9999;
    static ByteBuffer bb = ByteBuffer.allocate(1000);

    public static void main(String[] args) throws InterruptedException {
        int port = DEFAULT_PORT;
        if (args.length > 0)
            port = Integer.parseInt(args[0]);
        try {
            SocketChannel sc = SocketChannel.open();
            InetSocketAddress addr = new InetSocketAddress("localhost", port);
            sc.connect(addr);
//            long time = 0;
//            while (sc.read(bb) != -1) {
//                bb.flip();
//                while (bb.hasRemaining()) {
//                    time <<= 8;
//                    time |= bb.get() & 255;
//                }
//                bb.clear();
//            }
//            System.out.println(new Date(time));

            int read = sc.read(bb);
            bb.flip();

            System.out.println("Received: " + new String(bb.array()));


            bb.flip();
            sc.write(ByteBuffer.wrap("!!!".getBytes()));
            Thread.sleep(1000L);
            sc.write(ByteBuffer.wrap("+++".getBytes()));


            sc.close();
        } catch (IOException ioe) {
            System.err.println("I/O error: " + ioe.getMessage());
        }
    }
}


