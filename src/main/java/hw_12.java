import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.json.simple.*;
import java.io.FileWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.NoSuchElementException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class hw_12 {

    public static void main(String[] args) {
        try {
            ExecutorService threadPool = Executors.newFixedThreadPool(3);
            H2OGenerator GeneratorH2O = new H2OGenerator();
            for(int i = 0; i < 5; i++) {
                threadPool.execute(() -> GeneratorH2O.oxygenReleaser(new ReleaseOxygen()));
                threadPool.execute(() -> GeneratorH2O.hydrogenReleaser(new ReleaseHydrogen()));
                threadPool.execute(() -> GeneratorH2O.hydrogenReleaser(new ReleaseHydrogen()));
            }
            threadPool.shutdown();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
