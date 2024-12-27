package com.stuff.location_service.repository;

import com.stuff.location_service.model.Household;
import com.stuff.location_service.model.Location;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface LocationRepository extends MongoRepository<Location, String> {
    List<Location> findAllByHouseholdId(String householdId);
}
