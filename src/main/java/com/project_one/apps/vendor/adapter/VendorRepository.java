package com.project_one.apps.vendor.adapter;

import com.project_one.apps.vendor.adapter.model.Vendor;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, UUID> {

  Vendor findByVendorCategoryType(String vendorCategoryType);

  List<Vendor> findByUserId(String userId);
}
