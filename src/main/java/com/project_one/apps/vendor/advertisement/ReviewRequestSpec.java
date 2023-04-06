package com.project_one.apps.vendor.advertisement;

public record ReviewRequestSpec (
    String userId,
    String adsId,
    String review
) { }
