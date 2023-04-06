package com.project_one.apps.vendor.book_vendor.resources;

import com.project_one.apps.vendor.book_vendor.core.BookVendorService;
import com.project_one.apps.vendor.book_vendor.resources.model.BookVendorRequestSpec;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BookVendorHandler {

  private BookVendorService bookVendorService;

  public ResponseEntity bookVendor(BookVendorRequestSpec bookVendorRequestSpec) {
    return bookVendorService.bookVendor(
        bookVendorRequestSpec.vendorId(),
        bookVendorRequestSpec.userId(),
        bookVendorRequestSpec.bookTime());
  }


}
