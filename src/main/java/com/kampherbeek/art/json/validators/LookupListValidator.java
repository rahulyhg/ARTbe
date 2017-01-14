package com.kampherbeek.art.json.validators;

import com.kampherbeek.art.json.representation.RequestInterface;
import com.kampherbeek.art.json.representation.RequestLookupInterface;
import org.springframework.stereotype.Component;

@Component
public class LookupListValidator extends ValidatorParent {

    @Override
    protected boolean isValid(RequestInterface request) {
        String localeTxt = ((RequestLookupInterface) request).getLocale();
        String LOCALE_NL = "nl";
        String LOCALE_EN = "en";
        return (localeTxt.equalsIgnoreCase(LOCALE_EN) || localeTxt.equalsIgnoreCase(LOCALE_NL));
    }
}
