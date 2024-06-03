package com.practice.lld.logger;

import com.practice.lld.logger.appender.LogAppender;

public class LoggerConfig {
  private LogLevel logLevel;
  private LogAppender appender;

  public LoggerConfig() {
  }

  public LoggerConfig(LogLevel logLevel, LogAppender logAppender) {
    this.logLevel = logLevel;
    this.appender = logAppender;
  }

  public LogLevel getLogLevel() {
    return logLevel;
  }

  public LogAppender getAppender() {
    return appender;
  }

  public void setLogLevel(LogLevel logLevel) {
    this.logLevel = logLevel;
  }

  public void setAppender(LogAppender appender) {
    this.appender = appender;
  }
}
