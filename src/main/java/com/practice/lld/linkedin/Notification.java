package com.practice.lld.linkedin;

import java.time.Instant;

public record Notification(
    String id, NotificationType notificationType, User forUser, String content, Instant time) {}
