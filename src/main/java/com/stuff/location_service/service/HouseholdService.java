package com.stuff.location_service.service;

import com.stuff.location_service.dto.HouseholdCreateRequest;
import com.stuff.location_service.dto.HouseholdDto;
import com.stuff.location_service.dto.UserDto;
import com.stuff.location_service.mapper.HouseholdMapper;
import com.stuff.location_service.model.Household;
import com.stuff.location_service.model.User;
import com.stuff.location_service.repository.HouseholdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.stuff.exception.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HouseholdService {

    private final HouseholdRepository householdRepository;
    HouseholdMapper mapper = new HouseholdMapper();

    public void createHousehold(HouseholdCreateRequest householdCreateRequest){
        householdRepository.save(mapper.toHousehold(householdCreateRequest, UUID.randomUUID().toString()));
    }

    public void addUserToHousehold(String id, UserDto userDTO){
        Household household = getHouseholdOrThrowException(id);
        List<User> existingMembers = household.getMembers();
        if (existingMembers == null) {
            household.setMembers(new ArrayList<User>());
            existingMembers = household.getMembers();
        }
        existingMembers.add(mapper.toUser(userDTO));
        household.setMembers(existingMembers);
        householdRepository.save(household);
    }

    public List<HouseholdDto> getHouseholds(){
        List<HouseholdDto> households = new ArrayList<HouseholdDto>();
        for (Household household : householdRepository.findAll()) {
            households.add(mapper.toHouseholdDto(household));
        }
        return households;
    }

    public HouseholdDto getHousehold(String id){
        Household household = getHouseholdOrThrowException(id);
        return mapper.toHouseholdDto(household);
    }

    public List<UserDto> getMembers(String id){
        ArrayList<UserDto> users = new ArrayList<UserDto>();
        Household household = getHouseholdOrThrowException(id);
        if (household.getMembers() != null) {
            for (User user : household.getMembers()) {
                users.add(mapper.toUserDto(user));
            }
        }
        return users;
    }

    private Household getHouseholdOrThrowException(String id){
        Optional<Household> household = householdRepository.findById(id);
        if (household.isEmpty()) {
            throw new EntityNotFoundException(String.format("Household with id='%s' not found", id));
        }
        return household.get();
    }

    public void updateHouseholdField(String id, HouseholdCreateRequest householdCreateRequest){
        Household household = getHouseholdOrThrowException(id);
        household.setSqft(householdCreateRequest.getSqft());
        household.setOwner(householdCreateRequest.getOwner());
        householdRepository.save(household);
    }
}
