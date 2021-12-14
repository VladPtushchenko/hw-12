import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


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
