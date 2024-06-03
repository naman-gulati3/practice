package com.practice.lld.logger.appender;

import com.practice.lld.logger.LogMessage;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class FileAppender implements LogAppender {
  private final String filepath;

  public FileAppender(String filepath) {
    this.filepath = filepath;
  }

  @Override
  public void append(LogMessage logMessage) {
    try(FileWriter fileWriter = new FileWriter(filepath, true)) {
      fileWriter.write(logMessage.toString() + "\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
