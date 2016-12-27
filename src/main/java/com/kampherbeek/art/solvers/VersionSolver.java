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
    private final String VERSION_KEY = "version";
    private final String TYPE_FULL = "full";
    private final String TYPE_SHORT = "short";
    private final String PROP_VERSION_FULL = "version.full";
    private final String PROP_VERSION_SHORT = "version.short";

    @Autowired
    public VersionSolver(final PropertiesReader reader) {
        this.reader = reader;
    }

    public VersionResponse solveRequest(VersionRequest request) {
        String property;
        String versionType = request.getVersionType();
        if (versionType.equalsIgnoreCase(TYPE_FULL)) {
            property = PROP_VERSION_FULL;
        } else {
            property = PROP_VERSION_SHORT;
            versionType = TYPE_SHORT;
        }
        String versionLabel = bundle.getString(VERSION_KEY);
        String versionId = versionLabel + " " + reader.getValueForProperty(property);
        return new VersionResponse(versionType, versionId);
    }
}
