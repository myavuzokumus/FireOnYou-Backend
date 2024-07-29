package games.sc_riber.FireOnYou.business.abstracts;

import games.sc_riber.FireOnYou.business.requests.CreateVehicleTypeRequest;
import games.sc_riber.FireOnYou.business.responses.GetAllVehicleTypesResponse;

import java.util.List;

public interface TypeService {

    List<GetAllVehicleTypesResponse> getAll();

    void add(CreateVehicleTypeRequest request);
}
