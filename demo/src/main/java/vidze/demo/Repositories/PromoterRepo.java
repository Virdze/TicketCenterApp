package vidze.demo.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import vidze.demo.Models.Promoter;

public interface PromoterRepo extends JpaRepository<Promoter,Integer> {
    Optional<Promoter> findPromoterByEmail(String email);
}
    