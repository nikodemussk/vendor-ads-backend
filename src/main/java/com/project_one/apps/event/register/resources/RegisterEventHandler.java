package com.project_one.apps.event.register.resources;

import com.project_one.apps.event.register.core.EventDetail;
import com.project_one.apps.event.register.core.RegisterEventService;
import com.project_one.apps.event.register.resources.contract.RegisterEventSpec;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RegisterEventHandler {

  private RegisterEventService registerEventService;

  public ResponseEntity<Object> createEvent(RegisterEventSpec registerEventSpec) {

    registerEventService.createEvent(EventDetail.builder()
        .eventName(registerEventSpec.eventName())
        .location(registerEventSpec.location())
        .dateTime(registerEventSpec.dateTime())
        .build());
    return ResponseEntity.ok("");
  }
}
