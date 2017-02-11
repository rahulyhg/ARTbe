package com.kampherbeek.art.json.validators;

import com.kampherbeek.art.json.representation.RequestInterface;
import lombok.NonNull;
import org.springframework.stereotype.Component;

/**
 * Generic validator for requests without parameters. The validation always returns true. Main use is to trigger
 * the method handleJson() in the parent class.
 */
@Component
public class NoParamValidator extends ValidatorParent {

    @Override
    protected boolean validated(@NonNull RequestInterface request) {
        return true;
    }
}
