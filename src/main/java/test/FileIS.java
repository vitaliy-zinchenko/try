package test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Vitalii Zinchenko
 */
public class FileIS {
    public static void main(String[] args) throws IOException, InterruptedException {

        while(true) {
            FileInputStream fileInputStream = new FileInputStream("/Users/vitaliizinchenko/test.sh");

//            Thread.sleep(10000);

            int value;
            while ((value = fileInputStream.read()) != -1) {
                System.out.println(value);
            }
        }
    }
}
