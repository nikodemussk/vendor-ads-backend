package com.project_one.apps.event.register.core;

import java.io.Serializable;
import java.time.ZonedDateTime;
import lombok.Builder;

@Builder
public record EventDetail(String eventName,
                          String location,
                          ZonedDateTime dateTime) implements Serializable {
}
