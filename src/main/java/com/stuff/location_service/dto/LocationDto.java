package com.stuff.location_service.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LocationDto {
    String id;
    String name;
    String householdId;
    String parentLocationId;
}
