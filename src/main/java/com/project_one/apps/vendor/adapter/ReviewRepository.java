package com.project_one.apps.vendor.adapter;


import com.project_one.apps.vendor.adapter.model.Review;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository  extends JpaRepository<Review, UUID>  {

  List<Review> findByAdsId(String adsId);

}
