package games.sc_riber.FireOnYou.dataAccess.abstracts;

import games.sc_riber.FireOnYou.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
    boolean existsByName(String name);
    User findByName(String name);
}
