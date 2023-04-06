package com.project_one.apps.vendor.advertisement;

import com.project_one.apps.vendor.vendor_image.adapter.model.VendorImage;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@ToString
@Getter
public class Advertisement {

  private String vendorId;
  @Id
  private String advertisementId;
  private String name;
  private String description;
  private String category;
  @OneToMany
  private List<VendorImage> images;

}
