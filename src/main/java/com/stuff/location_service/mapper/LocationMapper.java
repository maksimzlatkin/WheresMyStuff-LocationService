package com.stuff.location_service.mapper;

import com.stuff.location_service.dto.LocationCreateRequest;
import com.stuff.location_service.dto.LocationDto;
import com.stuff.location_service.model.Location;

public class LocationMapper {

    public Location toLocation(LocationDto locationDto){
        return Location.builder()
                .name(locationDto.getName())
                .id(locationDto.getId())
                .parentLocationId(locationDto.getParentLocationId())
                .householdId(locationDto.getHouseholdId()).build();
    }

    public LocationDto toLocationDto(Location location){
        return LocationDto.builder()
                .id(location.getId())
                .householdId(location.getHouseholdId())
                .name(location.getName())
                .parentLocationId(location.getParentLocationId()).build();
    }

    public Location toLocation(String id, LocationCreateRequest locationCreateRequest){
        return Location.builder()
                .name(locationCreateRequest.getName())
                .id(id)
                .parentLocationId(locationCreateRequest.getParentLocationId())
                .householdId(locationCreateRequest.getHouseholdId()).build();
    }
}
