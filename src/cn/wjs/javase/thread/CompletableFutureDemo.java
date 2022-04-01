package cn.wjs.javase.thread;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * runAsync(Runnable runnable)	                            使用ForkJoinPool.commonPool()作为它的线程池执行异步代码。
 * runAsync(Runnable runnable, Executor executor)	        使用指定的thread pool执行异步代码。
 * supplyAsync(Supplier<U> supplier)	                    使用ForkJoinPool.commonPool()作为它的线程池执行异步代码，异步操作有返回值
 * supplyAsync(Supplier<U> supplier, Executor executor)	    使用指定的thread pool执行异步代码，异步操作有返回值
 */
public class CompletableFutureDemo {

    public static void main(String[] args) throws Exception {

        long t1 = System.currentTimeMillis();

        CompletableFuture<String> cfTwo = CompletableFuture.supplyAsync(() -> {
            return queryCode("two");
        });
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            // list.add(String.valueOf(i));
            list.add(i);
        }

        List<CompletableFuture<String>> result = list.stream().map(e -> CompletableFuture.supplyAsync(() -> {
            return e;
        }).thenApplyAsync(x -> {
            return queryCode(x+"aaa");
        })).collect(Collectors.toList());

//        list.stream().forEach(e -> CompletableFuture.supplyAsync(() -> {
//            return "aaa";
//        }).thenApply(x -> {
//            return queryCode(x+"bbb");
//        }).thenAccept(System.out::println));

//
        CompletableFuture.allOf(result.toArray(new CompletableFuture[result.size()])).join();
         CompletableFuture.supplyAsync(() -> {
             return "hello";
         }).thenApply(x ->{
            return queryCode(x+"ccc");
         }).thenAccept(System.out::println);

//        list.stream().map(e -> CompletableFuture.completedFuture(e).thenApply(x -> {
//            return queryCode("two") + x;
//        }).thenAccept(System.out::println));

//        CompletableFuture<String> cfOne = CompletableFuture.supplyAsync(()->{
//            return queryCode("one");
//        });
//        //cfOne执行成功后继续执行下一个任务
//        CompletableFuture<String> oneNext = cfOne.thenApplyAsync((a)->{
//            return queryCode("oneNext" + a);
//        });
//        CompletableFuture<String> ctThree = CompletableFuture.supplyAsync(()->{
//            return queryCode("three");
//        });

//        System.out.println(ctThree.get());
//        System.out.println(cfOne.get());

        //   System.out.println(cfTwo.get());

        // System.out.println(oneNext.get());
        //   CompletableFuture.allOf(new CompletableFuture[cfOne, cfTwo]).join();

        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
        //    CompletableFuture.supplyAsync(() -> 1).thenApply(i -> i + 1).thenApply(i -> i * 1).whenComplete((r, e) -> System.out.println(e));
        // thenAccept和thenRun都是无返回值的

    }

    static String queryCode(String name) {
        // System.out.println("queryCode执行开始");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        //System.out.println("queryCode执行完毕");
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
