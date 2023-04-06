package com.project_one.apps.vendor.vendor_image.adapter;

import com.project_one.apps.vendor.vendor_image.adapter.model.VendorImage;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorImageRepository extends JpaRepository<VendorImage, Integer> {

  List<VendorImage> findAllByVendorId(String vendorId);
  List<VendorImage> findAllByAdvertisementId(String advertisementId);
}
