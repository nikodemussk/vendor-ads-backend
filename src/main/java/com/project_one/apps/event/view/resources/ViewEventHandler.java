package com.project_one.apps.event.view.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.project_one.apps.event.view.core.ViewEventService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class ViewEventHandler {

  private ViewEventService viewEventService;

  public ResponseEntity<String> getAll() {
    try {
      ObjectWriter ow = new ObjectMapper().registerModule(new JavaTimeModule()).writer().withDefaultPrettyPrinter();
      return ResponseEntity.ok(ow.writeValueAsString(viewEventService.getEvent()));
    } catch (JsonProcessingException jsonProcessingException) {
      log.error(jsonProcessingException.toString());
      return ResponseEntity.internalServerError().build();
    }
  }
}