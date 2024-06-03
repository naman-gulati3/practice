package com.practice.lld.logger;

import com.practice.lld.logger.appender.ConsoleAppender;

public class Logger {

  private LoggerConfig loggerConfig;

  private Logger() {
    this.loggerConfig = new LoggerConfig(LogLevel.INFO, new ConsoleAppender());
  }

  private static final class InstanceHolder {
    private static final Logger instance = new Logger();
  }

  public static Logger getInstance() {
    return InstanceHolder.instance;
  }

  public void setLoggerConfig(LoggerConfig loggerConfig) {
    this.loggerConfig = loggerConfig;
  }

  private void log(LogLevel logLevel, String message) {
    if(logLevel.ordinal() >= loggerConfig.getLogLevel().ordinal()) {
      LogMessage logMessage = new LogMessage(logLevel, message);
      loggerConfig.getAppender().append(logMessage);
    }
  }

  public void debug(String message) {
    log(LogLevel.DEBUG, message);
  }

  public void info(String message) {
    log(LogLevel.INFO, message);
  }

  public void warn(String message) {
    log(LogLevel.WARN, message);
  }

  public void error(String message) {
    log(LogLevel.ERROR, message);
  }

  public void fatal(String message) {
    log(LogLevel.FATAL, message);
  }
}
