package games.sc_riber.FireOnYou.business.rules;

import games.sc_riber.FireOnYou.core.utilities.exceptions.BusinessException;
import games.sc_riber.FireOnYou.dataAccess.abstracts.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserBusinessRules {

    private UserRepository userRepository;

    public void checkIfVehicleTypeIsExists(String vehicleType) {
        if (this.userRepository.existsByName(vehicleType)) {
            throw new BusinessException("Vehicle type already exists.");
        }

    }
}
