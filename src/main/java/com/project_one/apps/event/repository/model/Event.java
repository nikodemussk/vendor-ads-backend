package com.project_one.apps.event.repository.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Event {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Integer id;

  private String name;
  private String location;
  private ZonedDateTime dateTime;
}
