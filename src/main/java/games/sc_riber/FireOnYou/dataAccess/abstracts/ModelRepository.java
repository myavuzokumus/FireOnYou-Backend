package games.sc_riber.FireOnYou.dataAccess.abstracts;

import games.sc_riber.FireOnYou.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Integer> {
}
