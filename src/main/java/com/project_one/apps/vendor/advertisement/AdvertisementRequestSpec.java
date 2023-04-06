package com.project_one.apps.vendor.advertisement;

import com.project_one.apps.vendor.vendor_image.contract.VendorImageRequestSpec;
import java.util.List;

public record AdvertisementRequestSpec (
    String vendorId,
    String advertisementId,
    String name,
    String description,
    String category,
    VendorImageRequestSpec images
) {}
