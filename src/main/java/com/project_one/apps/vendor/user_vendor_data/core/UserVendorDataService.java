package com.project_one.apps.vendor.user_vendor_data.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;

public interface UserVendorDataService {

  ResponseEntity<String> vendorListByUser(String userUUID) throws JsonProcessingException;
}
