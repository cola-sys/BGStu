package com.kola.Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcComputation {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<CompletableFuture<Integer>> futures = new ArrayList<>();
        for (int start = 1; start <= 100; start += 10) {
            int from = start; // lambda表达式需要final或者最终final变量
            int to = start + 9;
            CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
                int sum = 0;
                for (int i = from; i <= to; i++) {
                    sum += i * i;
                }
                return sum;
            }, pool);
            futures.add(future);
        }
        // 一边读取一边阻塞
        int sum = futures.stream()
                .map(CompletableFuture::join)
                .mapToInt(Integer::intValue)
                .sum();

        // 所有任务完成后，join直接取值
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        int sum1 = futures.stream()
                .map(CompletableFuture::join)
                .mapToInt(Integer::intValue)
                .sum();

        pool.shutdown();

        System.out.println(sum + "===" + sum1);
    }
}
