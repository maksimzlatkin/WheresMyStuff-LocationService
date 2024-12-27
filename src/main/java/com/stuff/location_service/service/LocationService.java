package com.stuff.location_service.service;

import com.stuff.location_service.dto.HouseholdDto;
import com.stuff.location_service.dto.LocationCreateRequest;
import com.stuff.location_service.dto.LocationDto;
import com.stuff.location_service.mapper.LocationMapper;
import com.stuff.location_service.model.Household;
import com.stuff.location_service.model.Location;
import com.stuff.location_service.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.stuff.exception.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;
    LocationMapper mapper = new LocationMapper();

    public void createLocation(LocationCreateRequest locationCreateRequest){
        locationRepository.save(mapper.toLocation(UUID.randomUUID().toString(), locationCreateRequest));
    }

    public List<LocationDto> getLocations(){
        List<LocationDto> locations = new ArrayList<LocationDto>();
        for (Location location : locationRepository.findAll()) {
            locations.add(mapper.toLocationDto(location));
        }
        return locations;
    }

    public LocationDto getLocation(String id){
        Location location = getLocationOrThrowException(id);
        return mapper.toLocationDto(location);
    }

    public List<LocationDto> getLocationsFromHouseholdId(String householdId){
        List<LocationDto> locationDtos = new ArrayList<LocationDto>();
        for (Location location : locationRepository.findAllByHouseholdId(householdId)){
            locationDtos.add(mapper.toLocationDto(location));
        }
        return locationDtos;
    }

    public void updateLocation(String id, LocationCreateRequest locationCreateRequest){
        Location location = getLocationOrThrowException(id);
        location.setName(locationCreateRequest.getName());
        location.setHouseholdId(location.getHouseholdId());
        location.setParentLocationId(location.getParentLocationId());
        locationRepository.save(location);
    }

    private Location getLocationOrThrowException(String id){
        Optional<Location> location = locationRepository.findById(id);
        if (location.isEmpty()) {
            throw new EntityNotFoundException(String.format("Household with id='%s' not found", id));
        }
        return location.get();
    }
}
