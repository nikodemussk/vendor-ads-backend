package com.project_one.apps.event.register.resources;

import com.project_one.apps.encryption.Encryption;
import com.project_one.apps.event.register.resources.contract.RegisterEventSpec;
import java.net.URI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RegisterEventController {

  @Autowired
  private RegisterEventHandler registerEventHandler;

  @CrossOrigin(origins = "*")
  @PostMapping(path = "/event/create", consumes = "application/json")
  public ResponseEntity<String> createEvent(@RequestBody RegisterEventSpec registerEventSpec) {
    log.info("Request API: /event/create\nRequest Body: {}", registerEventSpec.toString());
    registerEventHandler.createEvent(registerEventSpec);

    return ResponseEntity.created(URI.create("https://google.com"))
        .body(Encryption.encrypt("123456789TestABCDAAABBBTest"));
  }
}
