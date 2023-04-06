package com.project_one.apps.vendor.advertisement;

import lombok.Builder;

@Builder
public record ReviewResponseSpec(
    String adsId,
    String review,
    String userName
) {}
