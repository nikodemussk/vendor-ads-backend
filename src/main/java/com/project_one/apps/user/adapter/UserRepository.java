package com.project_one.apps.user.adapter;

import com.project_one.apps.user.adapter.model.User;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
  User findByEmail(String email);
  User findByUserId(UUID userId);
}
