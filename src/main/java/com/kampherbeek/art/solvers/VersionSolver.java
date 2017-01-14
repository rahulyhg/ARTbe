package com.kampherbeek.art.solvers;

import com.kampherbeek.art.json.representation.VersionRequest;
import com.kampherbeek.art.json.representation.VersionResponse;
import com.kampherbeek.art.util.PropertiesReader;
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
    public VersionSolver(final PropertiesReader reader) {
        this.reader = reader;
    }

    public VersionResponse solveRequest(VersionRequest request) {
        String property;
        String versionType = request.getVersionType();
        String TYPE_FULL = "full";
        if (versionType.equalsIgnoreCase(TYPE_FULL)) {
            String PROP_VERSION_FULL = "version.full";
            property = PROP_VERSION_FULL;
        } else {
            String PROP_VERSION_SHORT = "version.short";
            property = PROP_VERSION_SHORT;
            String TYPE_SHORT = "short";
            versionType = TYPE_SHORT;
        }
        String VERSION_KEY = "version";
        String versionLabel = bundle.getString(VERSION_KEY);
        String versionId = versionLabel + " " + reader.getValueForProperty(property);
        return new VersionResponse(versionType, versionId);
    }
}
