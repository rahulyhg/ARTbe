package com.kampherbeek.art.json.validators;

import com.kampherbeek.art.json.representation.RequestInterface;
import com.kampherbeek.art.json.representation.RequestLookupInterface;
import org.springframework.stereotype.Component;

@Component
public class LookupListValidator extends ValidatorParent{

    private final String LOCALE_EN = "en";
    private final String LOCALE_NL = "nl";

    protected boolean isValid(RequestInterface request) {
        String localeTxt = ((RequestLookupInterface)request).getLocale();
        return (localeTxt.equalsIgnoreCase(LOCALE_EN) || localeTxt.equalsIgnoreCase(LOCALE_NL));
    }
}
