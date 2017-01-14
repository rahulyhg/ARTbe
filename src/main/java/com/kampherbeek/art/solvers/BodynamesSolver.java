package com.kampherbeek.art.solvers;

import com.kampherbeek.art.domain.Bodynames;
import com.kampherbeek.art.json.representation.BodynamesRequest;
import com.kampherbeek.art.json.representation.BodynamesResponse;
import com.kampherbeek.art.json.representation.StandardSelectionItem;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

@Component
public class BodynamesSolver {

    public BodynamesResponse solveRequest(BodynamesRequest request) {
        ResourceBundle bundle = ResourceBundle.getBundle("messages/messages", new Locale(request.getLocale()));
        List<StandardSelectionItem> allHouses = new ArrayList<>();
        for (Bodynames bodyname : Bodynames.values()) {
            String id = String.valueOf(bodyname.getInternalId());
            String key = bodyname.getRbKey();
            String label = bundle.getString(key);
            allHouses.add(new StandardSelectionItem(id, label));
        }
        return new BodynamesResponse(allHouses);
    }
}

