package com.project_one.apps.user.login.core;

import org.springframework.http.ResponseEntity;

public interface UserLoginService {

  ResponseEntity<String> login(String email, String password);
}
