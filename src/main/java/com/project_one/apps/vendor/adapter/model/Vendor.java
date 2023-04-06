package com.project_one.apps.vendor.adapter.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "vendors")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Vendor {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID vendorId;
  private String userId;
  private String vendorName;
  private String vendorCategoryType;
  private String vendorLocation;
  private List<String> vendorImages;
}
