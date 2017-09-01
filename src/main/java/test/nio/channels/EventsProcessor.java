package test.nio.channels;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Vitalii Zinchenko
 */
public class EventsProcessor {

    private int threadsNumber;
    private Selector selector;
    private ExecutorService executorService;

    private AcceptKeyHandler acceptKeyHandler;
    private ReadKeyHandler readKeyHandler;

    public EventsProcessor(int threadsNumber, Selector selector) {
        this.threadsNumber = threadsNumber;
        this.selector = selector;
        this.executorService = Executors.newFixedThreadPool(threadsNumber);
    }

    public void process(Event event) {

//        executorService.

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("!!!");
//                throw new RuntimeException("!!!!????");
            }
        });

        SelectionKey key = event.getKey();
        if (key.isAcceptable()) {
            executorService.submit(new AcceptKeyHandler(key));
        } else if(key.isReadable()) {
            executorService.submit(new ReadKeyHandler(key));
        } else {
            throw new IllegalArgumentException("Wrong key: " + key);
        }
    }

    private interface KeyHandler {
        void handle(SelectionKey key) throws IOException;
    }

    private class AcceptKeyHandler implements Runnable {

        private SelectionKey key;

        public AcceptKeyHandler(SelectionKey key) {
            this.key = key;
        }

        @Override
        public void run() {
            try {
                System.out.println("Run Acceptable");
                ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
                SocketChannel socketChannel = serverSocketChannel.accept();
                socketChannel.configureBlocking(false);
                socketChannel.register(selector, SelectionKey.OP_READ);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class ReadKeyHandler implements Runnable {
        private SelectionKey key;

        public ReadKeyHandler(SelectionKey key) {
            this.key = key;
        }

        @Override
        public void run() {
            try {
                System.out.println("Run Readable");
                SocketChannel socketChannel = (SocketChannel) key.channel();
                ByteBuffer bb = ByteBuffer.allocate(10);
                int read = socketChannel.read(bb);
                System.out.println(new String(bb.array()));

                ByteBuffer response = ByteBuffer.allocate(10);
                response.put("rt".getBytes());
                response.flip();
                socketChannel.write(response);
                socketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
