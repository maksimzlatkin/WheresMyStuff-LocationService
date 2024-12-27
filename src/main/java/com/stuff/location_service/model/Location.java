package com.stuff.location_service.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(value =  "locations")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Location {
    @Id
    String id;
    String name;
    String householdId;
    String parentLocationId;
}
