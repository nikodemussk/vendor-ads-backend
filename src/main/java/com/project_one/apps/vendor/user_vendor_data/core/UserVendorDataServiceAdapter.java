package com.project_one.apps.vendor.user_vendor_data.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project_one.apps.vendor.adapter.VendorAdapter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class UserVendorDataServiceAdapter implements UserVendorDataService{

  private VendorAdapter vendorAdapter;

  @Override
  public ResponseEntity<String> vendorListByUser(String userUUID)  {
    try {
      return vendorAdapter.getVendorByUserUUID(userUUID);
    } catch (JsonProcessingException e) {
      log.error(e.toString());
      return ResponseEntity.internalServerError().build();
    }
  }
}
