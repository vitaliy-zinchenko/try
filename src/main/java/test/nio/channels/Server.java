package test.nio.channels;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Vitalii Zinchenko
 */
public class Server {

    public static final int THREADS_NUMBER = 4;

    private ServerSocketChannel serverSocketChannel;

    private Selector selector;

    private EventsProcessor eventsProcessor;

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = new Server();
        server.start(60100);
    }

    public void start(int port) throws IOException {
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(port));

        selector = Selector.open();

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        eventsProcessor = new EventsProcessor(THREADS_NUMBER, selector);

        eventLoop();
    }

    private void eventLoop() throws IOException {
        while (true) {
            System.out.println("Selecting...");
            int selectedCount = selector.select();
            System.out.println("Selected: " + selectedCount);
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selected = iterator.next();
                eventsProcessor.process(new Event(selected));
//                if (selected.isAcceptable()) {
//                    SocketChannel socketChannel = serverSocketChannel.accept();
//                    socketChannel.configureBlocking(false);
//                    socketChannel.register(selector, SelectionKey.OP_READ);
//                }
//                if (selected.isReadable()) {
//                    SocketChannel socketChannel = (SocketChannel) selected.channel();
//                    ByteBuffer bb = ByteBuffer.allocate(10);
//                    int read = socketChannel.read(bb);
//                    System.out.println(new String(bb.array()));
//
//                    ByteBuffer response = ByteBuffer.allocate(10);
//                    response.put("rt".getBytes());
//                    response.flip();
//                    socketChannel.write(response);
//                    socketChannel.close();
//                }
//                selected.cancel();
                iterator.remove();
            }
        }
    }

    public void stop() {

    }

}
