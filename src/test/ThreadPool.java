package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Ikarosx
 * @date 2020/7/24 21:16
 */
public class ThreadPool {

    public static void main(String[] args) {
        SynchronizedExample e1 = new SynchronizedExample();
        SynchronizedExample e2 = new SynchronizedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> e1.func1());
        executorService.execute(() -> e2.func1());
    }

    static class SynchronizedExample {

        synchronized void func1() {
            for (int i = 0; i < 6; i++) {
                System.out.println(Thread.currentThread().getName() + "：" + i);
            }
        }
    }
}
