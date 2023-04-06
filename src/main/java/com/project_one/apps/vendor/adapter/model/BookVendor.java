package com.project_one.apps.vendor.adapter.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "bookVendor")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class BookVendor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID bookVendorID;
  private String userId;
  private String vendorId;
  private ZonedDateTime bookTime;
}
