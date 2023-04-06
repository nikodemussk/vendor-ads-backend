package com.project_one.apps.user.adapter;

import com.project_one.apps.user.adapter.model.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class UserAdapter {

  private UserRepository userRepository;

  public User getUser(String email) {
    return userRepository.findByEmail(email);
  }
}
