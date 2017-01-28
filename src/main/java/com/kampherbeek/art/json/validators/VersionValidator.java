package com.kampherbeek.art.json.validators;

import com.kampherbeek.art.json.representation.RequestInterface;
import com.kampherbeek.art.json.representation.VersionRequest;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class VersionValidator extends ValidatorParent {

    @Override
    protected boolean validated(@NonNull final RequestInterface request) {
        final String versionType = ((VersionRequest) request).getVersionType();
        final String fullType = "Full";
        final String shortType = "Short";
        return versionType.equalsIgnoreCase(shortType) || versionType.equalsIgnoreCase(fullType);
    }
}
