package com.kampherbeek.art.solvers;

import com.kampherbeek.art.domain.EphemerisRanges;
import com.kampherbeek.art.json.representation.EphemerisFilesResponse;
import com.kampherbeek.art.json.representation.SettingsResponse;
import com.kampherbeek.art.util.EphemerisFilesChecker;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EphemerisFilesSolver {

    private final SettingsSolver settingsSolver;
    private final EphemerisFilesChecker ephemerisFilesChecker;

    @Autowired
    public EphemerisFilesSolver(@NonNull SettingsSolver settingsSolver,
                                @NonNull EphemerisFilesChecker ephemerisFilesChecker) {
        this.settingsSolver = settingsSolver;
        this.ephemerisFilesChecker = ephemerisFilesChecker;
    }


    public EphemerisFilesResponse solveRequest() {
        SettingsResponse settingsResponse = settingsSolver.solveRequest();
        String sePath = settingsResponse.getSettings().getSePath();
        EphemerisRanges range = settingsResponse.getSettings().getEphemerisRange();
        boolean filesOk = ephemerisFilesChecker.checkRange(range, sePath);
        List<String> missingFiles = ephemerisFilesChecker.getMissingFiles();
        return new EphemerisFilesResponse(filesOk, missingFiles);
    }


}
