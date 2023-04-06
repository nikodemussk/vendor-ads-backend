package com.project_one.apps.vendor.adapter;

import com.project_one.apps.vendor.adapter.model.BookVendor;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BookVendorAdapter {

  private BookVendorRepository bookVendorRepository;

  public ResponseEntity bookVendor(String vendorId, String userId, ZonedDateTime bookTime) {
    bookVendorRepository.save(BookVendor.builder().vendorId(vendorId).userId(userId).bookTime(bookTime).build());
    return ResponseEntity.ok().build();
  }
}
