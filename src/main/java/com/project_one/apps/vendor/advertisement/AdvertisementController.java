package com.project_one.apps.vendor.advertisement;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.project_one.apps.user.adapter.UserRepository;
import com.project_one.apps.user.adapter.model.User;
import com.project_one.apps.vendor.adapter.ReviewRepository;
import com.project_one.apps.vendor.adapter.model.Review;
import com.project_one.apps.vendor.vendor_image.VendorImageController;
import com.project_one.apps.vendor.vendor_image.adapter.VendorImageRepository;
import com.project_one.apps.vendor.vendor_image.adapter.model.VendorImage;
import com.project_one.apps.vendor.vendor_image.contract.VendorImageRequestSpec;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AdvertisementController {

  @Autowired
  private AdvertisementRepository advertisementRepository;


  @Autowired
  private VendorImageRepository vendorImageRepository;

  @Autowired
  private ReviewRepository reviewRepository;

  @Autowired
  private UserRepository userRepository;

  @PostMapping("/vendor/ads")
  public ResponseEntity createAnAd(@RequestBody AdvertisementRequestSpec advertisement) {

    VendorImageController vendorImageController = new VendorImageController(vendorImageRepository);
//    List<VendorImage> vendorImages = new ArrayList<>();
//    for (VendorImageRequestSpec vendorImageRequestSpec : advertisement.images()) {
//      vendorImages.add(VendorImage.builder().imageFileName())
//    }
    VendorImageRequestSpec v = new VendorImageRequestSpec(
        advertisement.images().assets(),
        advertisement.images().didCancel(),
        advertisement.advertisementId(),
        advertisement.vendorId());

    Advertisement advertisement1 = Advertisement.builder()
            .advertisementId(advertisement.advertisementId())
                .vendorId(advertisement.vendorId())
                    .name(advertisement.name())
                        .description(advertisement.description())
                            .category(advertisement.category())
                                .images(vendorImageController.vendorImages(v))
        .build();

    advertisementRepository.save(advertisement1);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/vendor/ads")
  public ResponseEntity<List<Advertisement>> getAllAds() {
    return ResponseEntity.ok(advertisementRepository.findAll());
  }

  @GetMapping("/vendor/ads-by-id")
  public ResponseEntity<Advertisement> geAdsByAdvertisementId(@RequestParam String advertisementId) {
    return ResponseEntity.ok(advertisementRepository.findByAdvertisementId(advertisementId));
  }


  @GetMapping(value = "/vendor/ads/{category}", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Advertisement> getAdsByCategory(@PathVariable String category)
      throws JsonProcessingException {
    List<Advertisement> advertisements = advertisementRepository.findByCategory(category);
    log.info("{}", advertisements);
    return advertisements;
//    List<ResponseSpec> responseSpecs = new ArrayList<>();
//    advertisements.forEach(ads -> responseSpecs.add(ResponseSpec.builder()
//        .advertisementId(ads.getAdvertisementId())
//            .category(ads.getCategory())
//            .description(ads.getDescription())
//            .images(ads.getImages())
//            .name(ads.getName())
//            .vendorId(ads.getVendorId())
//        .build()));
//    return responseSpecs;
  }

  @PostMapping(value = "/vendor/ads/review")
  public ResponseEntity createAnReview(@RequestBody ReviewRequestSpec reviewRequestSpec) {
    log.info("{}", reviewRequestSpec);
    reviewRepository.save(Review.builder().customerReview(reviewRequestSpec.review()).adsId(reviewRequestSpec.adsId()).userId(reviewRequestSpec.userId()).build());
    return ResponseEntity.ok().build();
  }

  @GetMapping(value = "/vendor/ads/review")
  public ResponseEntity getReviews(@RequestParam String advertisementId) {
    log.info("/vendor/ads/review ads id: {}", advertisementId);
    List<Review> review = reviewRepository.findByAdsId(advertisementId);
    List<ReviewResponseSpec> reviewResponseSpecs = new ArrayList<>();
    review.forEach(data -> {
      User user = userRepository.findByUserId(UUID.fromString(data.getUserId()));
      reviewResponseSpecs.add(ReviewResponseSpec.builder().review(data.getCustomerReview()).adsId(data.getAdsId()).userName(user.getFullName()).build());
    });

    return ResponseEntity.ok(reviewResponseSpecs);
  }
}

