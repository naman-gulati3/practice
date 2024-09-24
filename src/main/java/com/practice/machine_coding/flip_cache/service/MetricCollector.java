package com.practice.machine_coding.flip_cache.service;

import java.util.concurrent.atomic.AtomicLong;

public class MetricCollector {

  private static MetricCollector instance;

  private static final AtomicLong CACHE_HIT_COUNT = new AtomicLong(0);

  private static final AtomicLong CACHE_MISS_COUNT = new AtomicLong(0);

  private MetricCollector() {
  }

  public static synchronized MetricCollector getInstance() {
    if (instance == null) {
      instance = new MetricCollector();
    }
    return instance;
  }

//  private static final AtomicLong CACHE_HIT_COUNT = new AtomicLong(0);
//
//  private static final AtomicLong CACHE_MISS_COUNT = new AtomicLong(0);

  public static long getCacheHitCount() {
    return CACHE_HIT_COUNT.get();
  }

  public static long getCacheMissCount() {
    return CACHE_MISS_COUNT.get();
  }

  public static void incCacheHit() {

    CACHE_HIT_COUNT.incrementAndGet();
  }

  public static void incCacheMiss() {
    CACHE_MISS_COUNT.incrementAndGet();
  }

  public static double getCacheHitRatio() {
    long total = CACHE_HIT_COUNT.get() + CACHE_MISS_COUNT.get();
    if (total == 0) {
      return 0;
    }
    return (double) CACHE_HIT_COUNT.get() / total;
  }
}
