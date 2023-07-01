package vidze.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import vidze.demo.Models.User;
import java.util.Optional;


public interface UserRepo extends JpaRepository<User,Integer> {
    Optional<User> findUserByEmail(String email);
}
