package games.sc_riber.FireOnYou.business.rules;

import games.sc_riber.FireOnYou.core.utilities.exceptions.BusinessException;
import games.sc_riber.FireOnYou.dataAccess.abstracts.VehicleTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VehicleTypeBusinessRules {

    private VehicleTypeRepository vehicleTypeRepository;

    public void checkIfVehicleTypeIsExists(String vehicleType) {
        if (this.vehicleTypeRepository.existsByName(vehicleType)) {
            throw new BusinessException("Vehicle type already exists.");
        }

    }
}
