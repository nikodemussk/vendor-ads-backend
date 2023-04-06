package com.project_one.apps.vendor.user_vendor_data.resources;

import com.project_one.apps.vendor.user_vendor_data.core.UserVendorDataServiceAdapter;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UserVendorDataHandler {

  private UserVendorDataServiceAdapter userVendorDataServiceAdapter;

  public ResponseEntity<String> vendorListByUser(String userUUID) {
    return userVendorDataServiceAdapter.vendorListByUser(userUUID);
  }
}
