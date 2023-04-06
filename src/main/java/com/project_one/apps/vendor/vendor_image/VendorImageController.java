package com.project_one.apps.vendor.vendor_image;

import com.project_one.apps.vendor.vendor_image.adapter.VendorImageRepository;
import com.project_one.apps.vendor.vendor_image.adapter.model.VendorImage;
import com.project_one.apps.vendor.vendor_image.contract.VendorImageRequestSpec;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class VendorImageController {

//  @Value("D:\\apps\\images\\vendor\\")
  private final String imageStorePath = "D:\\ftp\\";

  private final String imageBaseUri = "http://localhost:8443/";

  @Autowired
  private VendorImageRepository vendorImageRepository;

//  @PostMapping("/vendor/image")
//  public ResponseEntity vendorImage(@RequestBody MultipartFile multipartFile)
//      throws FileNotFoundException {
//    try {
//      if (!multipartFile.isEmpty()) {
//        File path = new File("D:\\test-images\\images\\" + multipartFile.getOriginalFilename());
//        path.createNewFile();
//        FileOutputStream output = new FileOutputStream(path);
//        output.write(multipartFile.getBytes());
//        output.close();
//        return ResponseEntity.ok().build();
//      }
//    } catch (IOException e) {
//      throw new RuntimeException(e);
//    }
//    return ResponseEntity.badRequest().build();
//  }

  @PostMapping("/vendor/ads/image")
  public List<VendorImage> vendorImages(@RequestBody VendorImageRequestSpec vendorImageRequestSpec) {
    log.info("Request API: /vendor/ads/image, Request Body: {}, {}", vendorImageRequestSpec.advertisementId(), vendorImageRequestSpec.assets().size());
    List<VendorImage> vendorImages = new ArrayList<>();
    vendorImageRequestSpec.assets().forEach(imagesAsset -> {
      try {
        String random = String.valueOf(Math.random());
        String imageFileName = imageStorePath
            .concat(vendorImageRequestSpec.advertisementId())
            .concat("SALIM")
            .concat(random)
            .concat(".png");

        String imageUri = imageBaseUri
            .concat(vendorImageRequestSpec.advertisementId())
            .concat("SALIM")
            .concat(random)
            .concat(".png");
        byte[] imagedata = DatatypeConverter.parseBase64Binary(
            imagesAsset.uri().substring(imagesAsset.uri().indexOf(",") + 1));
        BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(imagedata));
        ImageIO.write(bufferedImage, "png", new File(imageFileName));

        VendorImage vendorImage = VendorImage.builder()
            .imageFileName(imageUri)
            .vendorId(vendorImageRequestSpec.vendorId())
            .advertisementId(vendorImageRequestSpec.advertisementId())
            .build();
        vendorImageRepository.save(vendorImage);
        vendorImages.add(vendorImage);
      } catch (IOException ioException) {
        log.error(ioException.getMessage());
      }
    });
    return vendorImages;
  }

  @GetMapping("/vendor/ads/images")
  public ResponseEntity getVendorImages(@RequestParam String advertisementId) {
    log.info("Request API: /vendor/image");
    return ResponseEntity.ok(vendorImageRepository.findAllByVendorId(advertisementId));
  }
}
