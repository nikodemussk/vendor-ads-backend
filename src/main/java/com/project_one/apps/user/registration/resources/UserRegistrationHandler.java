package com.project_one.apps.user.registration.resources;

import com.project_one.apps.user.registration.core.UserRegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UserRegistrationHandler {

  private UserRegistrationService userRegistrationService;

  public ResponseEntity<String> registerUser(String email, String password, String fullName) {
    return userRegistrationService.registerUser(email, password, fullName);
  }
}
