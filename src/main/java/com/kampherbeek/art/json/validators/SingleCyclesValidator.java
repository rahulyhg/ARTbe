package com.kampherbeek.art.json.validators;

import com.kampherbeek.art.json.representation.RequestInterface;
import com.kampherbeek.art.json.representation.SingleCyclesRequest;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SingleCyclesValidator extends ValidatorParent{

    private static final Logger LOG = LoggerFactory.getLogger(SingleCyclesValidator.class);

    public SingleCyclesValidator() {
        super();
    }

    @Override
    protected boolean validated(@NonNull RequestInterface request) {
        try {
            SingleCyclesRequest scRequest = (SingleCyclesRequest) request;
            if (scRequest.getEndJdnr() <= scRequest.getStartJdnr() ||
                    scRequest.getPeriodResultFormat() == null ||
                    scRequest.getSingleCyclesMethod() == null) {
                return false;
            }
            return true;
        } catch (Exception e) {
            LOG.error("Exception: " + e);
            return false;
        }
    }
}
