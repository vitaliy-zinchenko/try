package test;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Vitalii Zinchenko
 */
public class HttpClientTest {
    public static void main(String[] args) throws IOException, InterruptedException {

        Thread.sleep(10000);

        while (true) {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet("http://google.com");
            HttpResponse response = client.execute(request);
            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            System.out.println(reader.readLine());
        }
    }
}
