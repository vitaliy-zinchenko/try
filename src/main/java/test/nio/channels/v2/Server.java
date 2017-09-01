package test.nio.channels.v2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
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
    private ServerSocketChannel serverSocketChannel;

    private Selector selector;


    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = new Server();
        server.start(60110);
    }

    public void start(int port) throws IOException {
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(port));

        selector = Selector.open();

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        eventLoop();
    }

    private void eventLoop() throws IOException {
        while (true) {
            System.out.println("---------------------------------------------------------------------------------");
            printKeysStatus();

            System.out.println("Selecting...");
            int selectedCount = selector.select();
            System.out.println("Selected: " + selectedCount);

            printKeysStatus();

            for (SelectionKey key : selector.keys()) {
                if (key.isValid() && key.channel().getClass().getSuperclass().equals(SocketChannel.class) && key.isReadable()) {
                    System.out.println("Set OP_WRITE for " + key.channel());
                    key.interestOps(SelectionKey.OP_WRITE);
                }
            }

            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selected = iterator.next();
                if (selected.isAcceptable()) {
                    System.out.println("Acceptable: " + selected.channel());
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                }
                if (selected.isWritable()) {
                    System.out.println("Writable: " + selected.channel());
                }
                if (selected.isReadable()) {
                    System.out.println("Acceptable: " + selected.channel());
                    SocketChannel socketChannel = (SocketChannel) selected.channel();
                    ByteBuffer bb = ByteBuffer.allocate(10);
                    int read = socketChannel.read(bb);
                    System.out.println(new String(bb.array()));

                    ByteBuffer response = ByteBuffer.allocate(10);
                    response.put("rt".getBytes());
                    response.flip();
                    socketChannel.write(response);
//                    socketChannel.close();
                }

                iterator.remove();
            }
        }
    }

    private void printKeysStatus() {
        for (SelectionKey key : selector.keys()) {
            if (key.isValid()) {
                System.out.println("SelectionKey: " + key.channel() + " with interest: readable=" + key.isReadable() + "; acceptable=" + key.isAcceptable() + "; writable=" + key.isWritable());
            } else {
                Socket socket = ((SocketChannel) key.channel()).socket();
                System.out.println("SelectionKey is not valid: " + socket.getLocalAddress() + ":" + socket.getLocalPort() + " | " + socket.getRemoteSocketAddress());
            }
        }
    }


}
