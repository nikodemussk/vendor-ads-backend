package com.project_one.apps.user.adapter.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID  userId;

  @Column(unique=true)
  private String email;
  private String password;
  private String fullName;
}
