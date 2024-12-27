package com.stuff.location_service.dto;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LocationCreateRequest {
    String name;
    String householdId;
    String parentLocationId;
}
