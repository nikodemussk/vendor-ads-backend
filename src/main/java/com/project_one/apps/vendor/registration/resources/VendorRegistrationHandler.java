package com.project_one.apps.vendor.registration.resources;

import com.project_one.apps.vendor.registration.core.VendorRegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class VendorRegistrationHandler {

  private VendorRegistrationService vendorRegistrationService;
  public ResponseEntity<String> registerVendor(String vendorName, String vendorType, String vendorLocation, String userUUID) {
    return vendorRegistrationService.vendorRegistration(vendorName, vendorType, vendorLocation, userUUID);
  }
}
