package com.project_one.apps.vendor.registration.core;

import com.project_one.apps.vendor.adapter.VendorAdapter;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VendorRegistrationServiceAdapter implements VendorRegistrationService{

  private VendorAdapter vendorAdapter;
  @Override
  public ResponseEntity<String> vendorRegistration(String vendorName, String vendorType, String vendorLocation, String userUUID) {
    return vendorAdapter.vendorRegistration(vendorName, vendorType, vendorLocation, userUUID);
  }
}
