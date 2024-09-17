package com.practice.lld.snowflake_id_generator;

import java.time.Instant;

public class IdGeneratorImpl implements IdGenerator {

  private static final long START_TIMESTAMP =
      Instant.parse("2024-01-01T00:00:00.00000Z").toEpochMilli();
  private static final long DATA_CENTER_BITS = 5L;
  private static final long SEQUENCE_BITS = 12L;
  private static final long MACHINE_BITS = 5L;

  private static final long MAX_DATACENTER_ID = (1L << DATA_CENTER_BITS) - 1;
  private static final long MAX_MACHINE_ID = (1L << MACHINE_BITS) - 1;
  private static final long MAX_SEQUENCE_ID = (1L << SEQUENCE_BITS) - 1;

  private static final long MACHINE_SHIFT = SEQUENCE_BITS;
  private static final long DATACENTER_SHIFT = SEQUENCE_BITS + MACHINE_BITS;
  private static final long TIMESTAMP_SHIFT = SEQUENCE_BITS + MACHINE_BITS + DATA_CENTER_BITS;

  private final long dataCenterId;
  private final long machineId;

  private long sequence = 0;
  private long lastTimestamp = -1;

  public IdGeneratorImpl(long dataCenterId, long machineId) {
    if (dataCenterId > MAX_DATACENTER_ID || dataCenterId < 0) {
      throw new IllegalArgumentException("Invalid data center id: %s".formatted(dataCenterId));
    }

    if (machineId > MAX_MACHINE_ID || machineId < 0) {
      throw new IllegalArgumentException("Invalid machine id id: %s".formatted(machineId));
    }

    this.dataCenterId = dataCenterId;
    this.machineId = machineId;
  }

  @Override
  public synchronized long generateId() {
    long timestamp = System.currentTimeMillis();

    if (timestamp < lastTimestamp) {
      throw new RuntimeException("Clock skewed");
    }

    if (timestamp == lastTimestamp) {
      sequence = (sequence + 1) & MAX_SEQUENCE_ID;

      if (sequence == 0) {
        timestamp = waitUntilNextTimestamp(lastTimestamp);
      }
    } else {
      sequence = 0L;
    }

    return ((timestamp - START_TIMESTAMP) << TIMESTAMP_SHIFT)
        | (dataCenterId << DATACENTER_SHIFT)
        | (machineId << MACHINE_SHIFT)
        | sequence;
  }

  private long waitUntilNextTimestamp(long lastTimestamp) {
    long timestamp = System.currentTimeMillis();
    while (timestamp <= lastTimestamp) {
      timestamp = System.currentTimeMillis();
    }
    return timestamp;
  }
}
