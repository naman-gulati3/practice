package com.practice.machine_coding.flip_cache.policies;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TimeBasedEvictionPolicy<K> extends EvictionPolicy<K> {

  private final Map<K, Instant> keyAccessTimeMap;

  public TimeBasedEvictionPolicy() {
    this.keyAccessTimeMap = new ConcurrentHashMap<>();
  }

  @Override
  public void keyAccessed(K key) {
    Instant accessTime = Instant.now();
    keyAccessTimeMap.put(key, accessTime);
  }

  @Override
  public K evict() {
    K oldestKey = null;
    Instant minTimestamp = null;

    for (var entry : keyAccessTimeMap.entrySet()) {
      if (minTimestamp == null) {
        minTimestamp = entry.getValue();
        oldestKey = entry.getKey();
      }

      if (entry.getValue().compareTo(minTimestamp) < 0) {
        minTimestamp = entry.getValue();
        oldestKey = entry.getKey();
      }
    }

    keyAccessTimeMap.remove(oldestKey);
    return oldestKey;
  }
}
