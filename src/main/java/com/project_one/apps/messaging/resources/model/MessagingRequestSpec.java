package com.project_one.apps.messaging.resources.model;

public record MessagingRequestSpec(
    String chatId,
    String vendorId,
    String userId,
    String sender,
    String message,
    String advertisementId
) {}
