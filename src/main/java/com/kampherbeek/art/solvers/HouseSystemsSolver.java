package com.kampherbeek.art.solvers;

import com.kampherbeek.art.domain.HouseSystems;
import com.kampherbeek.art.json.representation.HouseSystemsRequest;
import com.kampherbeek.art.json.representation.HouseSystemsResponse;
import com.kampherbeek.art.json.representation.StandardSelectionItem;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

@Component
public class HouseSystemsSolver {

    public HouseSystemsResponse solveRequest(HouseSystemsRequest request) {
        ResourceBundle bundle = ResourceBundle.getBundle("messages/messages", new Locale(request.getLocale()));
        List<StandardSelectionItem> allHouses = new ArrayList<>();
        for (HouseSystems system : HouseSystems.values()) {
            String id = String.valueOf(system.getInternalId());
            String key = system.getRbKey();
            String label = bundle.getString(key);
            allHouses.add(new StandardSelectionItem(id, label));
        }
        return new HouseSystemsResponse(allHouses);
    }
}

