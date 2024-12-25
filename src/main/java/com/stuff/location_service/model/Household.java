package com.stuff.location_service.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Getter
@Setter
@Document(value =  "households")
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Data
public class Household {
    @Id
    private String id;
    private String owner;
    private int sqft;

    private List<User> members;
}