package games.sc_riber.FireOnYou.dataAccess.abstracts;

import games.sc_riber.FireOnYou.entities.concretes.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, Integer> {
}
