package com.project_one.apps.event.register.core;

import com.project_one.apps.event.repository.model.Event;
import com.project_one.apps.event.repository.EventServiceAdapter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProcessRegisterEventService  implements RegisterEventService {

  private EventServiceAdapter eventServiceAdapter;

  @Override
  public void createEvent(EventDetail eventDetail) {
    eventServiceAdapter.createEvent(Event.builder()
        .name(eventDetail.eventName())
        .location(eventDetail.location())
        .dateTime(eventDetail.dateTime())
        .build());
  }
}
