package com.project_one.apps.event.view.resources;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ViewEventController {

  @Autowired
  private ViewEventHandler viewEventHandler;

  @GetMapping(path = "/event/getAll")
  public ResponseEntity<String> getEvents() {
    log.info("Request API: /event/getAll\nRequest Body: {}", "");
    return viewEventHandler.getAll();
  }
}
