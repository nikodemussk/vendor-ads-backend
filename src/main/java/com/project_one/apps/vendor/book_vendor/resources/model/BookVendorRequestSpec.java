package com.project_one.apps.vendor.book_vendor.resources.model;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public record BookVendorRequestSpec(
    String vendorId,
    String userId,
    ZonedDateTime bookTime
) {}
