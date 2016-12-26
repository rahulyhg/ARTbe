package com.kampherbeek.art.json.validators;

import com.kampherbeek.art.json.representation.HouseSystemsRequest;
import com.kampherbeek.art.json.representation.RequestInterface;
import org.springframework.stereotype.Component;

@Component
public class HouseSystemsValidator extends ValidatorParent{

    private final String LOCALE_EN = "en";
    private final String LOCALE_NL = "nl";

    protected boolean isValid(RequestInterface request) {
        String localeTxt = ((HouseSystemsRequest)request).getLocale();
        return (localeTxt.equalsIgnoreCase(LOCALE_EN) || localeTxt.equalsIgnoreCase(LOCALE_NL));
    }
}
