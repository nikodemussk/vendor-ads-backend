package com.project_one.apps.vendor.registration.core;

import org.springframework.http.ResponseEntity;

public interface VendorRegistrationService {
  ResponseEntity<String> vendorRegistration(String vendorName, String vendorType, String vendorLocation, String userUUID);
}
