package com.practice.lld.logger;

import com.practice.lld.logger.appender.ConsoleAppender;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    Logger logger = Logger.getInstance();
    logger.setLoggerConfig(new LoggerConfig(LogLevel.FATAL, new ConsoleAppender()));
    executorService.submit(
        () -> {
          logger.info("Info log from thread " + Thread.currentThread());
          logger.fatal("Fatal log from thread " + Thread.currentThread());
        });

    executorService.submit(
        () -> {
          logger.info("Info log from thread " + Thread.currentThread());
          logger.fatal("Fatal log from thread " + Thread.currentThread());
        });

    executorService.shutdown();
  }
}
