package games.sc_riber.FireOnYou.business.concretes;

import games.sc_riber.FireOnYou.business.abstracts.TypeService;
import games.sc_riber.FireOnYou.business.requests.CreateVehicleTypeRequest;
import games.sc_riber.FireOnYou.business.responses.GetAllVehicleTypesResponse;
import games.sc_riber.FireOnYou.core.utilities.mappers.ModelMapperService;
import games.sc_riber.FireOnYou.dataAccess.abstracts.VehicleTypeRepository;
import games.sc_riber.FireOnYou.entities.concretes.VehicleType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TypeManager implements TypeService {

    private VehicleTypeRepository vehicleTypeRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllVehicleTypesResponse> getAll() {
        // Business rules
        List<VehicleType> types = vehicleTypeRepository.findAll();
        List<GetAllVehicleTypesResponse> response = types.stream()
                .map(type -> modelMapperService.forResponse().map(type, GetAllVehicleTypesResponse.class)).toList();

        return response;
    }

    @Override
    public void add(CreateVehicleTypeRequest request) {
        // Business rules
        VehicleType type = this.modelMapperService.forRequest().map(request, VehicleType.class);
        vehicleTypeRepository.save(type);
    }


}
