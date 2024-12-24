package com.stuff.location_service.shared;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "wms")
//@PropertySource("application.properties")
public class ConfigProperty {

    private String mongoconnectionstring;

    // Getters and setters
    public String getProperty() {
        return mongoconnectionstring;
    }
    public void setProperty(String mongoconnectionstring) {
        this.mongoconnectionstring = mongoconnectionstring;
    }
}
