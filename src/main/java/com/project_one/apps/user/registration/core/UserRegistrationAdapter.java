package com.project_one.apps.user.registration.core;

import com.project_one.apps.user.adapter.UserRepository;
import com.project_one.apps.user.adapter.model.User;
import java.util.Objects;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserRegistrationAdapter implements UserRegistrationService {

  private UserRepository userRepository;

  @Override
  public ResponseEntity<String> registerUser(String email, String password, String fullName) {
    if (Objects.nonNull(userRepository.findByEmail(email))) {
      return ResponseEntity.badRequest().body("Email is used in another account");
    }

    if (StringUtils.isNotBlank(email) && StringUtils.isNotBlank(password)) {
      userRepository.save(User.builder().email(email).password(password).fullName(fullName).build());
      return ResponseEntity.ok().build();
    }

    return null;
  }
}
