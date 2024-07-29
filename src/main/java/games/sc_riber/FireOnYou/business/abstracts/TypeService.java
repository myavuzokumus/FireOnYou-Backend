package games.sc_riber.FireOnYou.business.abstracts;

import games.sc_riber.FireOnYou.business.requests.CreateVehicleTypeRequest;
import games.sc_riber.FireOnYou.business.requests.UpdateVehicleTypeRequest;
import games.sc_riber.FireOnYou.business.responses.GetAllVehicleTypesResponse;
import games.sc_riber.FireOnYou.business.responses.GetIdVehicleTypeResponse;

import java.util.List;

public interface TypeService {

    List<GetAllVehicleTypesResponse> getAll();

    GetIdVehicleTypeResponse getById(int id);
    void add(CreateVehicleTypeRequest request);
    void update(UpdateVehicleTypeRequest request);
    void delete(int id);
}
