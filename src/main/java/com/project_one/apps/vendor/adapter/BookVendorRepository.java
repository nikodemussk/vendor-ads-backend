package com.project_one.apps.vendor.adapter;

import com.project_one.apps.vendor.adapter.model.BookVendor;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookVendorRepository extends JpaRepository<BookVendor, UUID> {

}
