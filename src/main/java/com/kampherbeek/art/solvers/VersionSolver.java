package com.kampherbeek.art.solvers;

import com.kampherbeek.art.json.representation.VersionRequest;
import com.kampherbeek.art.json.representation.VersionResponse;
import com.kampherbeek.art.util.PropertiesReader;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.ResourceBundle;

@Component
public class VersionSolver {
    private final Locale locale = new Locale("EN");
    private final ResourceBundle bundle = ResourceBundle.getBundle("messages/messages", locale);
    private final PropertiesReader reader;

    @Autowired
    public VersionSolver(@NonNull final PropertiesReader reader) {
        this.reader = reader;
    }

    public VersionResponse solveRequest(@NonNull final VersionRequest request) {
        final String propVersionFull = "version.full";
        final String propVersionShort = "version.short";
        final String typeFull = "full";
        final String typeShort = "short";
        final String versionKey = "version";
        String property;
        String versionType = request.getVersionType();
        if (versionType.equalsIgnoreCase(typeFull)) {
            property = propVersionFull;
        } else {
            property = propVersionShort;
            versionType = typeShort;
        }

        String versionLabel = bundle.getString(versionKey);
        String versionId = versionLabel + " " + reader.readValueForProperty(property);
        return new VersionResponse(versionType, versionId);
    }
}