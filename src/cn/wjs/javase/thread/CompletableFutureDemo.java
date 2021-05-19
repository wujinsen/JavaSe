package cn.wjs.javase.thread;

import java.util.concurrent.CompletableFuture;

/**
 * runAsync(Runnable runnable)	                            使用ForkJoinPool.commonPool()作为它的线程池执行异步代码。
 * runAsync(Runnable runnable, Executor executor)	        使用指定的thread pool执行异步代码。
 * supplyAsync(Supplier<U> supplier)	                    使用ForkJoinPool.commonPool()作为它的线程池执行异步代码，异步操作有返回值
 * supplyAsync(Supplier<U> supplier, Executor executor)	    使用指定的thread pool执行异步代码，异步操作有返回值
 *
 */
public class CompletableFutureDemo {
    public static void main(String[] args) throws  Exception{
        CompletableFuture<String> cfTwo = CompletableFuture.supplyAsync(()->{
            return queryCodeTwo("two");
        });

        CompletableFuture<String> cfOne = CompletableFuture.supplyAsync(()->{
            return queryCode("one");
        });

        CompletableFuture<String> oneNext = cfOne.thenApplyAsync((a)->{
            return queryCode("oneNext");
        });

        CompletableFuture<String> ctThree = CompletableFuture.supplyAsync(()->{
            return queryCodeTwo("three");
        });

        System.out.println(ctThree.get());
        System.out.println(cfOne.get());
        System.out.println(cfTwo.get());
        System.out.println(oneNext.get());
        oneNext.thenAccept((result)->{
            System.out.println(result);
        });
      //  CompletableFuture<String> cfFetch =
     //   Thread.sleep(1000);
    }
    static String queryCode(String name) {
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
        }
        return name;
    }
    static String queryCodeTwo(String name) {
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
        }
        return name;
    }
}
