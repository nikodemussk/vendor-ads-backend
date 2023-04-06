package com.project_one.apps.event.view.core;

import com.project_one.apps.event.repository.model.Event;
import java.util.List;

public interface ViewEventService {
  List<Event> getEvent();
}
