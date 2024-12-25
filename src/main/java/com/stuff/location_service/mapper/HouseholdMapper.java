package com.stuff.location_service.mapper;

import com.stuff.location_service.dto.HouseholdCreateRequest;
import com.stuff.location_service.dto.HouseholdDto;
import com.stuff.location_service.dto.UserDto;
import com.stuff.location_service.model.Household;
import com.stuff.location_service.model.User;
import org.bson.Document;

public class HouseholdMapper {
    public HouseholdDto toHouseholdDto(Household household){
        return HouseholdDto.builder()
                .id(household.getId())
                .owner(household.getOwner())
                .sqft(household.getSqft())
                .members(household.getMembers())
                .build();
    }

    public Household toHousehold(HouseholdDto householdDTO){
        return Household.builder()
                .id(householdDTO.getId())
                .owner(householdDTO.getOwner())
                .sqft(householdDTO.getSqft())
                .members(householdDTO.getMembers())
                .build();
    }

    public Household toHousehold(HouseholdCreateRequest householdCreateRequest, String houseHoldId){
        return Household.builder()
                .id(houseHoldId)
                .owner(householdCreateRequest.getOwner())
                .sqft(householdCreateRequest.getSqft())
                .build();
    }

    public User toUser(UserDto userDTO){
        return new User(userDTO.getEmail(), userDTO.getName());
    }

    public UserDto toUserDto(User user){
        return new UserDto(user.getEmail(), user.getName());
    }
}
