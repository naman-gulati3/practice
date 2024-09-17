package com.practice.lld.logger.appender;

import com.practice.lld.logger.LogMessage;

public class ConsoleAppender implements LogAppender {

  @Override
  public void append(LogMessage logMessage) {
    System.out.println(logMessage);
  }
}
