package test.nio.nio2;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;


/**
 * Created by Vitalii Zinchenko
 */
public class Server2 {

    final static int DEFAULT_PORT = 9999;
    static ByteBuffer bb = ByteBuffer.allocate(1000);

    public static void main(String[] args) throws Exception {
        int port = DEFAULT_PORT;
        if (args.length > 0)
            port = Integer.parseInt(args[0]);
        System.out.println("Server starting ... listening on port " + port);
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ServerSocket ss = ssc.socket();
        ss.bind(new InetSocketAddress(port));
        ssc.configureBlocking(false);
        Selector s = Selector.open();
        SelectionKey serverChannelRegistrationSelectionKey = ssc.register(s, SelectionKey.OP_ACCEPT);
        System.out.println("Registered server channel with selector.");
        while (true) {
            System.out.println("Selecting...");
            int n = s.select();
            System.out.println("Selected [" + n + "]");
            if (n == 0)
                continue;
            Iterator it = s.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey key = (SelectionKey) it.next();
                if (key.isAcceptable()) {
                    SocketChannel sc;
                    sc = ((ServerSocketChannel) key.channel()).accept();
                    if (sc == null)
                        continue;

                    sc.configureBlocking(false);
                    sc.register(s, SelectionKey.OP_READ);

                    System.out.println("Receiving connection");
                    bb.clear();

                    String msg = new Date().toString();

                    bb.put(msg.getBytes());
                    bb.flip();
                    System.out.println("Writing current time");
                    while (bb.hasRemaining())
                        sc.write(bb);
//                    sc.close();
                    bb.clear();
                }
                if (key.isReadable()) {
                    System.out.println("Reading...");
//                    bb.clear();

                    readDataFromSocket(key);


                }
                it.remove();
            }
        }
    }

    private static void readDataFromSocket(SelectionKey key)
            throws Exception { key.cancel();
        SocketChannel socketChannel = (SocketChannel) key.channel();
        int count;
        bb.clear();            // Empty buffer
        // Loop while data is available; channel is nonblocking
        while ((count = socketChannel.read(bb)) > 0) {
            bb.flip();        // Make buffer readable
            // Send the data; don't assume it goes all at once
//            while (bb.hasRemaining()) {
//                socketChannel.write(bb);
//            }

            System.out.println("Received: " + new String(bb.array()));

            // WARNING: the above loop is evil.  Because
            // it's writing back to the same nonblocking
            // channel it read the data from, this code can
            // potentially spin in a busy loop.  In real life
            // you'd do something more useful than this.
            bb.clear();        // Empty buffer
        }
        if (count < 0) {
            // Close channel on EOF, invalidates the key
            socketChannel.close();
        }
    }

}
