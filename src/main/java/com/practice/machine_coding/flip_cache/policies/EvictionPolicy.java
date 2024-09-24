package com.practice.machine_coding.flip_cache.policies;

public abstract class EvictionPolicy<K> {

  public abstract void keyAccessed(K key);

  public abstract K evict();
}
