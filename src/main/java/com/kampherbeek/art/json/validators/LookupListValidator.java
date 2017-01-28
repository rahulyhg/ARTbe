package com.kampherbeek.art.json.validators;

import com.kampherbeek.art.json.representation.RequestInterface;
import com.kampherbeek.art.json.representation.RequestLookupInterface;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class LookupListValidator extends ValidatorParent {

    @Override
    protected boolean validated(@NonNull final RequestInterface request) {
        final String localeTxt = ((RequestLookupInterface) request).getLocale();
        final String localeNL = "nl";
        final String localeEN = "en";
        return localeTxt.equalsIgnoreCase(localeEN) || localeTxt.equalsIgnoreCase(localeNL);
    }
}
