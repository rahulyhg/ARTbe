package com.kampherbeek.art.config;

import com.kampherbeek.art.domain.EphemerisRanges;
import lombok.Getter;
import lombok.Setter;


public class Settings {

    @Getter
    @Setter
    private String sePath;

    @Getter
    @Setter
    private EphemerisRanges ephemerisRange;

    public Settings() {
        // empty constructor for Json
    }

}
