package com.project_one.apps.user.login.resources;

import com.project_one.apps.user.login.core.UserLoginService;
import com.project_one.apps.user.login.resources.model.LoginRequestSpec;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@AllArgsConstructor
public class LoginController {

  private UserLoginService userLoginService;
  @PostMapping("/login")
  public ResponseEntity login(@RequestBody LoginRequestSpec loginRequestSpec) {
    log.info("Request API: /login\nRequest Body: {}", loginRequestSpec);
    return userLoginService.login(loginRequestSpec.email(), loginRequestSpec.password());
  }
}
