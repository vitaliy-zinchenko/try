package test.nio.channels;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Vitalii Zinchenko
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(60100));

        Selector selector = Selector.open();

        SelectionKey registeredSocket = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while(true) {
            System.out.println("Selecting...");
            int selectedCount = selector.select();
            System.out.println("Selected: " + selectedCount);
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();
            while(iterator.hasNext()) {
                SelectionKey selected = iterator.next();
                if(selected.isAcceptable()) {
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                }
                if(selected.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) selected.channel();
                    ByteBuffer bb = ByteBuffer.allocate(10);
                    int read = socketChannel.read(bb);
                    System.out.println(new String(bb.array()));
//                    bb.clear();
//                    bb.put("rt".getBytes());

                    ByteBuffer response = ByteBuffer.allocate(10);
                    response.put("rt".getBytes());
                    response.flip();
                    socketChannel.write(response);
                    socketChannel.close();
                }
//                selected.cancel();
                iterator.remove();
            }
        }

//        while (true) {
//            System.out.println("Waiting for connection...");
//            SocketChannel socketChannel = serverSocketChannel.accept();
//            System.out.println("Accepted connection.");
//
//            ByteBuffer buffer = ByteBuffer.allocate(100);
//            while (socketChannel.read(buffer) != -1) {
//                System.out.println("The data arrived: " + new String(buffer.array()));
//
//            }
//        }

//        System.out.println("end");
    }
}
