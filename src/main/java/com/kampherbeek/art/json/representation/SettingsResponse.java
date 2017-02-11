package com.kampherbeek.art.json.representation;

import com.kampherbeek.art.config.Settings;
import lombok.Getter;
import lombok.Setter;

public class SettingsResponse implements ResponseInterface {

    @Getter
    @Setter
    private Settings settings;

}
