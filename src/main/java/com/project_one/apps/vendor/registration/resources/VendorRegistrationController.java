package com.project_one.apps.vendor.registration.resources;

import com.project_one.apps.user.registration.resources.UserRegistrationHandler;
import com.project_one.apps.user.registration.resources.model.UserRegistrationRequestSpec;
import com.project_one.apps.vendor.registration.resources.model.VendorRegistrationRequestSpec;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class VendorRegistrationController {

  private VendorRegistrationHandler vendorRegistrationHandler;

  @PostMapping("/vendor/register")
  public ResponseEntity<String> registerUser(@RequestBody VendorRegistrationRequestSpec vendorRegistrationRequestSpec) {
    log.info("Request API: /login\nRequest Body: {}", vendorRegistrationRequestSpec);
    return vendorRegistrationHandler.registerVendor(
        vendorRegistrationRequestSpec.vendorName(),
        vendorRegistrationRequestSpec.vendorCategoryType(),
        vendorRegistrationRequestSpec.vendorLocation(),
        vendorRegistrationRequestSpec.userUUID()
    );
  }

}
