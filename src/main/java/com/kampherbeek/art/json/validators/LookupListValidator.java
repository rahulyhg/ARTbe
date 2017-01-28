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
        final String LOCALE_NL = "nl";
        final String LOCALE_EN = "en";
        return (localeTxt.equalsIgnoreCase(LOCALE_EN) || localeTxt.equalsIgnoreCase(LOCALE_NL));
    }
}
