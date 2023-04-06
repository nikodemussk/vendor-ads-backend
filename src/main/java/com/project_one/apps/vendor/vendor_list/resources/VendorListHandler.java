package com.project_one.apps.vendor.vendor_list.resources;

import com.project_one.apps.vendor.adapter.model.Vendor;
import com.project_one.apps.vendor.vendor_list.core.VendorListService;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class VendorListHandler {

  private VendorListService vendorListService;

  public ResponseEntity<String> vendorListByCategory(String category) {
    return vendorListService.vendorListByCategory(category);
  }

  public ResponseEntity<List<Vendor>> vendorData() {
    return vendorListService.vendorData();
  }
}
