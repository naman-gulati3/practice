package com.practice.machine_coding.flip_cache;

import com.practice.machine_coding.flip_cache.policies.TimeBasedEvictionPolicy;
import com.practice.machine_coding.flip_cache.repository.InMemoryStore;
import com.practice.machine_coding.flip_cache.service.FlipCacheImpl;
import com.practice.machine_coding.flip_cache.service.MetricCollector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CacheDemo {

  public static void main(String[] args) throws InterruptedException {
    MetricCollector.getInstance();
    var evictionPolicy = new TimeBasedEvictionPolicy<String>();

    InMemoryStore<String, String> store = new InMemoryStore<>();
    store.addEvictionPolicy(evictionPolicy);
    FlipCacheImpl<String, String> cache = new FlipCacheImpl<>(store, 10);

    ExecutorService service = Executors.newFixedThreadPool(3);
    CountDownLatch latch = new CountDownLatch(5);

    service.submit(
        new Thread(
            () -> {
              cache.put("name", "Software Engineer");
              latch.countDown();
            }));

    service.submit(
        new Thread(
            () -> {
              cache.put("Age", "27");
              latch.countDown();
            }));

    service.submit(
        new Thread(
            () -> {
              cache.put("Location", "Uttarakhand");
              cache.put("Location1", "Uttarakhand");
              cache.put("Location2", "Uttarakhand");
              cache.put("Location3", "Uttarakhand");
              cache.put("Location4", "Uttarakhand");
              cache.put("Location5", "Uttarakhand");
              cache.put("Location6", "Uttarakhand");
              cache.put("Location7", "Uttarakhand");
              cache.put("Location8", "Uttarakhand");
              cache.put("Location9", "Uttarakhand");
              latch.countDown();
            }));

    service.submit(
        new Thread(
            () -> {
              System.out.println(cache.get("Location")); // not null
              latch.countDown();
            }));

    service.submit(
        new Thread(
            () -> {
              System.out.println(cache.get("name")); // null
              latch.countDown();
            }));
    service.shutdown();

    latch.await();
    System.out.println(MetricCollector.getCacheHitCount());
    System.out.println(MetricCollector.getCacheMissCount());
    System.out.println(MetricCollector.getCacheHitRatio());
  }
}
