package com.project_one.apps.vendor.book_vendor.core;

import com.project_one.apps.vendor.adapter.BookVendorAdapter;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookVendorServiceAdapter implements BookVendorService {

  private BookVendorAdapter bookVendorAdapter;

  @Override
  public ResponseEntity bookVendor(String vendorId, String userId, ZonedDateTime bookTime) {
    return bookVendorAdapter.bookVendor(vendorId, userId, bookTime );
  }
}
