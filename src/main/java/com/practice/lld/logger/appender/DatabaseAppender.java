package com.practice.lld.logger.appender;

import com.practice.lld.logger.LogMessage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class DatabaseAppender implements LogAppender {
  private final String jdbcUrl;
  private final String username;

  private final String password;

  public DatabaseAppender(String jdbcUrl, String username, String password) {
    this.jdbcUrl = jdbcUrl;
    this.username = username;
    this.password = password;
  }

  @Override
  public void append(LogMessage logMessage) {
    try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
      PreparedStatement statement =
          connection.prepareStatement(
              """
         INSERT INTO logs (level, message, timestamp) VALUES(?, ?, ?)
         """);
      statement.setString(1, logMessage.getLogLevel().name());
      statement.setString(2, logMessage.getMessage());
      statement.setTimestamp(3, Timestamp.from(logMessage.getTime()));

      statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
