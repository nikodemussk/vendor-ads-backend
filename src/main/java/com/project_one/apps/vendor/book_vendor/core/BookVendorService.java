package com.project_one.apps.vendor.book_vendor.core;

import com.project_one.apps.vendor.book_vendor.resources.model.BookVendorRequestSpec;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import org.springframework.http.ResponseEntity;

public interface BookVendorService {
  ResponseEntity bookVendor(String vendorId, String userId, ZonedDateTime bookTime);
}