package com.project_one.apps.vendor.advertisement;

import com.project_one.apps.vendor.vendor_image.adapter.model.VendorImage;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ResponseSpec {

  private String vendorId;

  private String advertisementId;
  private String name;
  private String description;
  private String category;
  private List<VendorImage> images;
}
