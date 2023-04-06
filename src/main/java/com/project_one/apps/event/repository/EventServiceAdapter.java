package com.project_one.apps.event.repository;

import com.project_one.apps.event.repository.model.Event;
import java.util.List;

public interface EventServiceAdapter {

  void createEvent(Event event);

  List<Event> getEvents();
}
