package test.nio.channels;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Vitalii Zinchenko
 */
public class M {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(4);
        service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("!!!");
            }
        });

        Thread.sleep(10000L);
    }
}
