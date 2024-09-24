package com.practice.machine_coding.flip_cache.service;

import com.practice.machine_coding.flip_cache.repository.DataStore;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class FlipCacheImpl<K, V> implements FlipCache<K, V> {

  private final ReentrantReadWriteLock lock;

  private final ReadLock readLock;

  private final WriteLock writeLock;

  private final int capacity;

  private final DataStore<K, V> store;

  public FlipCacheImpl(DataStore<K, V> dataStore, int capacity) {
    this.capacity = capacity;
    this.store = dataStore;
    this.lock = new ReentrantReadWriteLock();
    this.readLock = lock.readLock();
    this.writeLock = lock.writeLock();
  }

  @Override
  public V get(K key) {
    readLock.lock();
    try {
      return store.get(key);
    } finally {
      readLock.unlock();
    }
  }

  @Override
  public void put(K key, V value) {
    writeLock.lock();
    try {
      if (store.size() >= capacity) {
        store.evict();
      }
      store.put(key, value);
    } finally {
      writeLock.unlock();
    }
  }
}
