package com.project_one.apps.user.login.core;

import com.project_one.apps.user.adapter.UserAdapter;
import com.project_one.apps.user.adapter.model.User;
import java.util.Objects;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserLoginServiceAdapter implements UserLoginService {

  private UserAdapter userAdapter;
  @Override
  public ResponseEntity login(String email, String password) {
    User user = userAdapter.getUser(email);
    if (Objects.nonNull(user) && StringUtils.isNotBlank(user.getPassword()) && user.getPassword().equals(password)) {
      return ResponseEntity.ok(user);
    }
    return ResponseEntity.badRequest().body("Wrong email or password");
  }
}
