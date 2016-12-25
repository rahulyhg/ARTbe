package com.kampherbeek.art.util;

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

    @Autowired
    private Environment env;

    public String getValueForProperty(String searchProp){
        return env.getProperty(searchProp);
    }

}
