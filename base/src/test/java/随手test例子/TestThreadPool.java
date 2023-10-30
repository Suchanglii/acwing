package 随手test例子;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadPool {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {

                }
            });
        }
        Executors.newCachedThreadPool().execute(new Runnable() {
            @Override
            public void run() {

            }
        });

        Executors.newScheduledThreadPool(3).execute(new Runnable() {
            @Override
            public void run() {

            }
        });

        // new ThreadPoolExecutor(1,10,)
   }
}
