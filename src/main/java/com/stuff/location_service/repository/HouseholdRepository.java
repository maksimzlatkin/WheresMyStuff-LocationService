package com.stuff.location_service.repository;

import com.stuff.location_service.model.Household;
import com.stuff.location_service.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface HouseholdRepository extends MongoRepository<Household, String> {

}
