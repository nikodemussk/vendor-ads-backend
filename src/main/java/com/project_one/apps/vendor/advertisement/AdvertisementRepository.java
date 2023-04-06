package com.project_one.apps.vendor.advertisement;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertisementRepository extends JpaRepository<Advertisement, UUID> {

  List<Advertisement> findByCategory(String category);
  Advertisement findByAdvertisementId(String advertisementId);
}
