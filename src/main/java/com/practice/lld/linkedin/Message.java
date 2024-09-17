package com.practice.lld.linkedin;

import java.time.Instant;

public record Message(String body, Instant time, User from, User to) {}
