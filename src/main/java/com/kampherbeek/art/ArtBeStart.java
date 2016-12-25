package com.kampherbeek.art;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArtBeStart {
    private static final Logger LOG = LoggerFactory.getLogger(ArtBeStart.class);


    public static void main(String[] args) {
        SpringApplication.run(ArtBeStart.class, args);
        LOG.info("ART started");
        System.out.println("ART backend started: in your browser type http://localhost:8080/....");
    }



}
