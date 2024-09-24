package com.practice.machine_coding.flip_cache.repository;

public interface DataStore<K, V> {

  void put(K key, V value);

  V get(K key);

  void evict();

  int size();
}
