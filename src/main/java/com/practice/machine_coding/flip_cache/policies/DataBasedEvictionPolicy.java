package com.practice.machine_coding.flip_cache.policies;

public class DataBasedEvictionPolicy<K> extends EvictionPolicy<K> {

  public DataBasedEvictionPolicy() {}

  @Override
  public void keyAccessed(K key) {}

  @Override
  public K evict() {
    return null;
  }
}
