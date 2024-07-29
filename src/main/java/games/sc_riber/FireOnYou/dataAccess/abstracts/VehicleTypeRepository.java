package games.sc_riber.FireOnYou.dataAccess.abstracts;

import games.sc_riber.FireOnYou.entities.concretes.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface VehicleTypeRepository extends JpaRepository<VehicleType, Integer>{

}
