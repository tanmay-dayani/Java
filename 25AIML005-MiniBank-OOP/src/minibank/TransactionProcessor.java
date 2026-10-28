package minibank;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TransactionProcessor implements AutoCloseable {
    private final ExecutorService pool = Executors.newFixedThreadPool(4);
    public void submit(Runnable task) { pool.execute(task); }
    @Override public void close() throws InterruptedException {
        pool.shutdown();
        if (!pool.awaitTermination(10, TimeUnit.SECONDS)) pool.shutdownNow();
    }
}
