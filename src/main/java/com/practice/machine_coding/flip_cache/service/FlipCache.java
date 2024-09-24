package com.practice.machine_coding.flip_cache.service;

public interface FlipCache<K, V> {

  V get(K key);

  void put(K key, V value);
}
