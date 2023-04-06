package com.project_one.apps.user.registration.core;

import org.springframework.http.ResponseEntity;

public interface UserRegistrationService {

  ResponseEntity<String> registerUser(String email, String password, String fullName);
}
