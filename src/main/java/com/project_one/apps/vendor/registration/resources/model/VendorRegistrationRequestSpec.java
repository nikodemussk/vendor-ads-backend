package com.project_one.apps.vendor.registration.resources.model;

public record VendorRegistrationRequestSpec(
    String vendorCategoryType,
    String vendorName,
    String vendorLocation,
    String userUUID
){}