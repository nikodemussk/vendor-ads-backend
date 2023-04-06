package com.project_one.apps.messaging.repository.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import java.time.ZonedDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Messaging {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID uuid;
    String chatId;
    String vendorId;
    String userId;
    String sender;
    String message;
    String advertisementId;
    ZonedDateTime createdDateTime;

//    @OneToOne
//    @JoinColumn(name = "fullName")
//    String userFullName;
}