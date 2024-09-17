package com.practice.lld.logger;

import java.time.Instant;

public class LogMessage {
  private final LogLevel logLevel;
  private Instant time;

  private final String message;

  public LogMessage(LogLevel logLevel, String message) {
    this.logLevel = logLevel;
    this.time = Instant.now();
    this.message = message;
  }

  public LogLevel getLogLevel() {
    return logLevel;
  }

  public Instant getTime() {
    return time;
  }

  public String getMessage() {
    return message;
  }

  @Override
  public String toString() {
    return "[" + logLevel + "] " + time + ": message='" + message;
  }
}
