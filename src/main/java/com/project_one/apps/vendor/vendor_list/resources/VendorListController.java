package com.project_one.apps.vendor.vendor_list.resources;

import com.project_one.apps.vendor.adapter.model.Vendor;
import com.project_one.apps.vendor.registration.resources.model.VendorRegistrationRequestSpec;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class VendorListController {

  private VendorListHandler vendorListHandler;

  @GetMapping("/vendor/list")
  public ResponseEntity<String> vendorListByCategory(@RequestParam String category) {
    log.info("Request API: /vendor/list\nRequest Param: {}", category);
    return vendorListHandler.vendorListByCategory(category);
  }

  @GetMapping("/vendor/list/a")
  public ResponseEntity<List<Vendor>> vendorListByCategory() {
    log.info("Request API: /vendor/list");
    return vendorListHandler.vendorData();
  }

}
