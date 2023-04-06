package com.project_one.apps.event.repository;

import com.project_one.apps.event.repository.model.Event;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class EventAdapter implements EventServiceAdapter{

  private EventRepository eventRepository;

  @Override
  public void createEvent(Event event) {
    eventRepository.save(event);
  }

  @Override
  public List<Event> getEvents() {
    List<Event> events = eventRepository.findAll().stream().toList();
    events.stream().forEach(data -> log.info(data.getName()));
    return events;
  }
}
