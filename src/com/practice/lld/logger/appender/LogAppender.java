package com.practice.lld.logger.appender;

import com.practice.lld.logger.LogMessage;

public interface LogAppender {
  void append(LogMessage logMessage);
}
