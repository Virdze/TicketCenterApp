package vidze.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository

import vidze.demo.Models.User;

public interface UserRepo extends JpaRepository<User,Integer> {
    
}
