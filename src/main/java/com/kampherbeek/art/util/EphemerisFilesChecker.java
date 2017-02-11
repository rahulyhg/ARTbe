package com.kampherbeek.art.util;

import com.kampherbeek.art.domain.EphemerisRanges;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class EphemerisFilesChecker {

    private final PropertiesReader propertiesReader;
    @Getter
    private List<String> missingFiles;

    @Autowired
    public EphemerisFilesChecker(@NonNull PropertiesReader propertiesReader) {
        this.propertiesReader = propertiesReader;
        missingFiles = new ArrayList<>();
    }

    public boolean checkRange(@NonNull EphemerisRanges range, @NonNull String locationEphemerisFiles) {
        boolean filesOk = checkFiles(EphemerisRanges.CURRENT.getPropertyName(), locationEphemerisFiles);
        if (range == EphemerisRanges.EXPANDED) {
            filesOk = filesOk && checkFiles(EphemerisRanges.EXPANDED.getPropertyName(), locationEphemerisFiles);
        }
        if (range == EphemerisRanges.FULL) {
            filesOk = filesOk && checkFiles(EphemerisRanges.FULL.getPropertyName(), locationEphemerisFiles);
        }
        return filesOk;
    }

    private boolean checkFiles(@NonNull String propertyName, @NonNull String locationEphemerisFiles) {
        final String comma = ",";
        String filesText = propertiesReader.readValueForProperty(propertyName);
        String[] filesToCheck = filesText.split(comma);
        boolean result = true;
        for (String filename : filesToCheck) {
            if (!checkSpecificFile(filename, locationEphemerisFiles)) {
                result = false;
                missingFiles.add(filename);
            }
        }
        return result;
    }


    private boolean checkSpecificFile(@NonNull String filename, @NonNull String locationEphemerisFiles) {
        File testFile = new File(locationEphemerisFiles + filename);
        return testFile.exists();
    }

}
