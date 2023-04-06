package com.project_one.apps.vendor.vendor_list.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project_one.apps.vendor.adapter.VendorAdapter;
import com.project_one.apps.vendor.adapter.model.Vendor;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class VendorListServiceAdapter implements VendorListService {

  private VendorAdapter vendorAdapter;

  @Override
  public ResponseEntity<String> vendorListByCategory(String category) {
    try {
      return vendorAdapter.getVendorByCategory(category);
    } catch (JsonProcessingException e) {
      log.error("Exception Occurred: {} ", e.getMessage());
      return ResponseEntity.internalServerError().body("Unable to get category");
    }
  }

  @Override
  public ResponseEntity<List<Vendor>> vendorData() {
    return null;
  }
}
