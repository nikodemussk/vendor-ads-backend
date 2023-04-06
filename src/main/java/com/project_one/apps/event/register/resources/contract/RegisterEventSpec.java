package com.project_one.apps.event.register.resources.contract;

import java.io.Serializable;
import java.time.ZonedDateTime;

public record RegisterEventSpec(String eventName,
                                String location,
                                ZonedDateTime dateTime) implements Serializable {
}
