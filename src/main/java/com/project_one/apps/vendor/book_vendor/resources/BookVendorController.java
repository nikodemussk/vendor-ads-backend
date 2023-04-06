package com.project_one.apps.vendor.book_vendor.resources;

import com.project_one.apps.vendor.book_vendor.resources.model.BookVendorRequestSpec;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@AllArgsConstructor
public class BookVendorController {

  private BookVendorHandler bookVendorHandler;

  @PostMapping("/vendor/book")
  public ResponseEntity bookVendor(@RequestBody BookVendorRequestSpec bookVendorRequestSpec) {
    log.info("Request API: /vendor/book\nRequest Body: {}", bookVendorRequestSpec);
    return bookVendorHandler.bookVendor(bookVendorRequestSpec);
  }
}
