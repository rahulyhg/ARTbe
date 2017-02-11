package com.kampherbeek.art.solvers;

import com.kampherbeek.art.config.Settings;
import com.kampherbeek.art.domain.EphemerisRanges;
import com.kampherbeek.art.json.representation.SettingsResponse;
import com.kampherbeek.art.util.JsonReader;
import com.kampherbeek.art.util.PropertiesReader;
import lombok.NonNull;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class SettingsSolver {

    private final JsonReader jsonReader;
    private final PropertiesReader propReader;

    @Autowired
    public SettingsSolver(@NonNull JsonReader jsonReader, @NonNull PropertiesReader propReader) {
        this.jsonReader = jsonReader;
        this.propReader = propReader;
    }

    public SettingsResponse solveRequest() {
        String settingsPath = propReader.readValueForProperty("settings.path");
        File settingsFile = new File(settingsPath);
        JSONObject object  = jsonReader.readObjectFromFile(settingsFile);
        Settings settings = readSettingsFromJson(object);
        return createSettingsResponse(settings);
    }

    private Settings readSettingsFromJson(JSONObject object) {
        String sePath = (String)object.get("sePath");
        String rangeText = (String)object.get("ephemerisRange");
        EphemerisRanges range = EphemerisRanges.valueOf(rangeText);
        Settings settings = new Settings();
        settings.setSePath(sePath);
        settings.setEphemerisRange(range);
        return settings;
    }

    private SettingsResponse createSettingsResponse(Settings settings) {
        SettingsResponse response = new SettingsResponse();
        response.setSettings(settings);
        return response;
    }
}
