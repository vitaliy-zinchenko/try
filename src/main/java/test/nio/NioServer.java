package test.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

/**
 * Created by Vitalii Zinchenko
 */
public class NioServer {

    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.bind(new InetSocketAddress("localhost", 10100));
        serverChannel.configureBlocking(false);
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);

        ByteBuffer buffer = ByteBuffer.allocate(256);

        while (true) {
            System.out.println("Selecting...");
            int selected = selector.select();
            System.out.println("Selected: " + selected);
            Set<SelectionKey> keys = selector.selectedKeys();

            for (SelectionKey key : keys) {
                if (key.isAcceptable()) {
                    System.out.println("Acceptable");
                    SocketChannel acceptedChannel = serverChannel.accept();
                    acceptedChannel.configureBlocking(false);
                    acceptedChannel.register(selector, SelectionKey.OP_READ);
                    InetAddress clientAddress = acceptedChannel.socket().getInetAddress();
                    System.out.println("New connection accepted from: " + clientAddress);
                }
                if (key.isReadable()) {
                    System.out.println("Readable");
                }
            }
        }

    }

}
