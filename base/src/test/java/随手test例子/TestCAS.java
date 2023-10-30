package 随手test例子;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TestCAS {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        AtomicInteger inc = new AtomicInteger();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,1,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>());
        Future future = null;
        for (int i = 0; i < 100; i++) {
            future = executor.submit(inc::getAndIncrement);
        }
        int result = (int)future.get();
        System.out.println(result);
        executor.shutdown();
    }
}
