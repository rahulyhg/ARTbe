package com.kampherbeek.art.util;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Reads property from application.properties
 */
@Configuration
@PropertySource("classpath:application.properties")
public class PropertiesReader {

    private final Environment env;

    @Autowired
    public PropertiesReader(@NonNull final Environment env) {
        this.env = env;
    }

    public String readValueForProperty(@NonNull final String searchProp) {
        return env.getProperty(searchProp);
    }
}
