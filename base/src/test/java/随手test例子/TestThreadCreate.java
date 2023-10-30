package 随手test例子;

import java.util.concurrent.*;

public class TestThreadCreate {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //1
//        ExecutorService executor = Executors.newCachedThreadPool();
//        Task task = new Task();
//        Future future = executor.submit(task);
//        Object o = future.get();
//        System.out.println(o);
        //2
        ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();
        FutureTask futureTask = new FutureTask(task);
        Future<?> future = executor.submit(futureTask);
        System.out.println(future.get());
        executor.shutdown();

        //3
//        Task task = new Task();
//        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
//        Thread thread = new Thread(futureTask);
//        thread.start();

    }

}

class Task implements Callable {

    @Override
    public Object call() throws Exception {
        System.out.println("子线程在进行计算");
        Thread.sleep(3000);
        int sum = 0;
        for(int i=0;i<100;i++)
            sum += i;
        return sum;
    }
}
