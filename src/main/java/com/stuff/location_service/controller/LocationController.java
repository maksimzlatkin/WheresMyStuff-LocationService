package com.stuff.location_service.controller;

import com.stuff.location_service.dto.HouseholdCreateRequest;
import com.stuff.location_service.dto.HouseholdDto;
import com.stuff.location_service.dto.LocationCreateRequest;
import com.stuff.location_service.dto.LocationDto;
import com.stuff.location_service.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"api/households/{householdId}/locations"})
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createLocation(@RequestBody LocationCreateRequest locationCreateRequest){
        locationService.createLocation(locationCreateRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<LocationDto> getLocations(@PathVariable String householdId){
        return locationService.getLocationsFromHouseholdId(householdId);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public LocationDto getLocation(@PathVariable String id){
        return locationService.getLocation(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateLocation(@PathVariable String id, @RequestBody LocationCreateRequest locationCreateRequest){
        locationService.updateLocation(id, locationCreateRequest);
    }
}
