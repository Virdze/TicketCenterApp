package vidze.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vidze.demo.Models.User;
import vidze.demo.Repositories.UserRepo;

@Service
public class UserService{

    private final UserRepo user_repo;

    @Autowired
    public UserService(UserRepo user_repo){
        this.user_repo = user_repo;
    }

    public List<User> getUsers(){
        return List.of(new User(1, 
                               23,
                              "João Freitas",
                             "email@email.com",
                          "password",
                             965359023,
                             null));
    }

}