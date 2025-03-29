package com.practice.machine_coding.flip_cache.repository;

import com.practice.machine_coding.flip_cache.policies.EvictionPolicy;
import com.practice.machine_coding.flip_cache.service.MetricCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryStore<K, V> implements DataStore<K, V> {

  private final Map<K, V> store;

  private final List<EvictionPolicy<K>> evictionPolicies;

  public InMemoryStore() {
    this.evictionPolicies = new ArrayList<>();
    this.store = new ConcurrentHashMap<>();
  }

  @Override
  public void put(K key, V value) {
    evictionPolicies.forEach(ep -> ep.keyAccessed(key));
    this.store.put(key, value);
  }

  @Override
  public V get(K key) {
    V value = store.get(key);
    evictionPolicies.forEach(ep -> ep.keyAccessed(key));
    if (value == null) {
      MetricCollector.incCacheMiss();
      return null;
    }
    MetricCollector.incCacheHit();
    return value;
  }

  @Override
  public void evict() {
    this.evictionPolicies.forEach(
        ep -> {
          K keyToRemove = ep.evict();
          store.remove(keyToRemove);
        });
  }

  @Override
  public int size() {
    return store.size();
  }

  public void addEvictionPolicy(EvictionPolicy<K> evictionPolicy) {
    this.evictionPolicies.add(evictionPolicy);
  }
}
