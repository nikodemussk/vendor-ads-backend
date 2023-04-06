package com.project_one.apps.event.view.core;

import com.project_one.apps.event.repository.EventServiceAdapter;
import com.project_one.apps.event.repository.model.Event;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProcessViewEvent implements ViewEventService{

  private EventServiceAdapter eventServiceAdapter;

  @Override
  public List<Event> getEvent() {
    return eventServiceAdapter.getEvents();
  }
}
