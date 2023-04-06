package com.project_one.apps.vendor.vendor_image.contract;

import java.util.List;


public record VendorImageRequestSpec(
    List<ImagesAsset> assets,
    Boolean didCancel,
    String advertisementId,
    String vendorId
) {}

