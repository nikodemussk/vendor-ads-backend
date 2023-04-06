package com.project_one.apps.vendor.user_vendor_data.resources;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class UserVendorDataController {

  private UserVendorDataHandler userVendorDataHandler;

  @GetMapping("/user/vendor/list")
  public ResponseEntity<String> vendorListByUser(@RequestParam String userUUID) {
    log.info("Request API: /user/vendor/list\nRequest Body: {}", userUUID);
    return userVendorDataHandler.vendorListByUser(userUUID);
  }

}
