package com.project_one.apps.vendor.vendor_list.core;

import com.project_one.apps.vendor.adapter.model.Vendor;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;

public interface VendorListService {
  ResponseEntity<String> vendorListByCategory(String category);

  ResponseEntity<List<Vendor>> vendorData();
}
