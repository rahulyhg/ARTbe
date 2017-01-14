package com.kampherbeek.art.json.validators;

import com.kampherbeek.art.json.representation.RequestInterface;
import com.kampherbeek.art.json.representation.VersionRequest;
import org.springframework.stereotype.Component;

@Component
public class VersionValidator extends ValidatorParent {

    @Override
    protected boolean isValid(RequestInterface request) {
        String versionType = ((VersionRequest) request).getVersionType();
        String fullType = "Full";
        String shortType = "Short";
        return (versionType.equalsIgnoreCase(shortType) || versionType.equalsIgnoreCase(fullType));
    }
}
