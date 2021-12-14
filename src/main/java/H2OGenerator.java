import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

class H2OGenerator {
    private Semaphore oxygen;
    private Semaphore hydrogen;
    private CyclicBarrier cyclicBarrier;

    public H2OGenerator() {
        this.oxygen = new Semaphore(1);
        this.hydrogen = new Semaphore(2);
        this.cyclicBarrier = new CyclicBarrier(3);
    }

    public void hydrogenReleaser(Runnable releaseHydrogen)  {
        try {
            hydrogen.acquire();
            releaseHydrogen.run();
            cyclicBarrier.await();
            hydrogen.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void oxygenReleaser(Runnable releaseOxygen) {
        try {
            oxygen.acquire();
            releaseOxygen.run();
            cyclicBarrier.await();
            oxygen.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    }

    class ReleaseOxygen implements Runnable {
        public void run() {
                System.out.println("O");
        }
    }

    class ReleaseHydrogen implements Runnable {
        public void run() {
           System.out.println("H");
        }
    }

