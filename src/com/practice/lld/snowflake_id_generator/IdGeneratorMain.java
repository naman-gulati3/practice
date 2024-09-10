package com.practice.lld.snowflake_id_generator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IdGeneratorMain {

  public static void main(String[] args) {
    IdGeneratorImpl idGenerator = new IdGeneratorImpl(10, 10);
    ExecutorService service = Executors.newFixedThreadPool(3);

    Thread t1 = new Thread(() -> System.out.println(idGenerator.generateId()));
    Thread t2 = new Thread(() -> System.out.println(idGenerator.generateId()));
    Thread t3 = new Thread(() -> System.out.println(idGenerator.generateId()));
    service.submit(t1);
    service.submit(t2);
    service.submit(t3);
    service.shutdown();
  }
}
