package com.kampherbeek.art.json.validators;

import com.kampherbeek.art.json.representation.CalculatedChartRequest;
import com.kampherbeek.art.json.representation.RequestInterface;
import com.kampherbeek.art.json.validators.helpers.JdnrHelper;
import com.kampherbeek.art.json.validators.helpers.LocationHelper;
import com.kampherbeek.art.json.validators.helpers.SimpleDateTimeHelper;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalculatedChartValidator extends ValidatorParent {

    private final LocationHelper locationHelper;
    private final SimpleDateTimeHelper dateTimeHelper;

    @Autowired
    public CalculatedChartValidator(@NonNull final JdnrHelper jdnrHelper,
                                    @NonNull final LocationHelper locationHelper,
                                    @NonNull final SimpleDateTimeHelper dateTimeHelper) {
        JdnrHelper jdnrHelper1 = jdnrHelper;
        this.locationHelper = locationHelper;
        this.dateTimeHelper = dateTimeHelper;
    }

    @Override
    protected boolean validated(@NonNull final RequestInterface request) {
        CalculatedChartRequest ccRequest = (CalculatedChartRequest) request;
        return dateTimeHelper.checkDateTimeValid(ccRequest.getSimpleDateTime())
                && locationHelper.checkLocationValid(ccRequest.getLocation());
    }
}
