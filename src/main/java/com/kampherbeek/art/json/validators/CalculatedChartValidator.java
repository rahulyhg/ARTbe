package com.kampherbeek.art.json.validators;

import com.kampherbeek.art.json.representation.CalculatedChartRequest;
import com.kampherbeek.art.json.representation.RequestInterface;
import com.kampherbeek.art.json.validators.helpers.JdnrHelper;
import com.kampherbeek.art.json.validators.helpers.LocationHelper;
import com.kampherbeek.art.json.validators.helpers.SimpleDateTimeHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalculatedChartValidator extends ValidatorParent {

    private final LocationHelper locationHelper;
    private final SimpleDateTimeHelper dateTimeHelper;

    @Autowired
    public CalculatedChartValidator(JdnrHelper jdnrHelper, LocationHelper locationHelper,
                                    SimpleDateTimeHelper dateTimeHelper) {
        JdnrHelper jdnrHelper1 = jdnrHelper;
        this.locationHelper = locationHelper;
        this.dateTimeHelper = dateTimeHelper;
    }

    @Override
    protected boolean isValid(RequestInterface request) {
        CalculatedChartRequest ccRequest = (CalculatedChartRequest) request;
        return dateTimeHelper.isValid(ccRequest.getSimpleDateTime())
                && locationHelper.isValid(ccRequest.getLocation());
    }
}
