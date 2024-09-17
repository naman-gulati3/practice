package com.practice.lld.stack_overflow;

import java.time.Instant;

public record Comment(int id, int author, String body, Instant createdAt) {}
