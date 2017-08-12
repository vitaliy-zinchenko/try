package test;

/**
 * Created by Vitalii Zinchenko
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {


        Thread.sleep(1000000);

        int count = 0;
        while (true) {
            System.out.println(count++);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1_000_000_000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

    }

}