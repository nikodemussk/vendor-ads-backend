package com.project_one.apps.vendor.adapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.project_one.apps.vendor.adapter.model.Vendor;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class VendorAdapter {

  private VendorRepository vendorRepository;

  public ResponseEntity<String> vendorRegistration(String vendorName, String vendorCategoryType, String vendorLocation, String userUUID) {
    vendorRepository.save(
        Vendor.builder().vendorName(vendorName).vendorCategoryType(vendorCategoryType).vendorLocation(vendorLocation).userId(userUUID).build()
    );
    return ResponseEntity.ok().build();
  }

  public ResponseEntity<String> getVendorByCategory(String vendorCategoryType)
      throws JsonProcessingException {
      Vendor vendor = vendorRepository.findByVendorCategoryType(vendorCategoryType);
      ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
      return ResponseEntity.ok(objectWriter.writeValueAsString(vendor));
  }

  public ResponseEntity<String> getVendorByUserUUID(String userUUID)
      throws JsonProcessingException {
    List<Vendor> vendor = vendorRepository.findByUserId(userUUID);
    log.info("Vendor: {}", vendor);
    ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
    return ResponseEntity.ok(objectWriter.writeValueAsString(vendor.stream().toList()));
  }
}
