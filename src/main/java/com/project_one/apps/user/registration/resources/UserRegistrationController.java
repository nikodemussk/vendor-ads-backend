package com.project_one.apps.user.registration.resources;

import com.project_one.apps.user.registration.resources.model.UserRegistrationRequestSpec;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class UserRegistrationController {
  private UserRegistrationHandler userRegistrationHandler;

  @PostMapping("/register")
  public ResponseEntity<String> registerUser(@RequestBody UserRegistrationRequestSpec userRegistrationRequestSpec) {
    log.info("Request API: /login\nRequest Body: {}", userRegistrationRequestSpec);
    return userRegistrationHandler.registerUser(
        userRegistrationRequestSpec.email(),
        userRegistrationRequestSpec.password(),
        userRegistrationRequestSpec.fullName());
  }
}
