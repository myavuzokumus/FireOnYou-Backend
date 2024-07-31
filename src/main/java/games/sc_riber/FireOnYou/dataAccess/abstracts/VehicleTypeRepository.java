package games.sc_riber.FireOnYou.dataAccess.abstracts;

import games.sc_riber.FireOnYou.entities.concretes.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleTypeRepository extends JpaRepository<VehicleType, Integer>{
    boolean existsByName(String name);
}
