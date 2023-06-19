package vidze.demo.Services;

import java.util.List;

import org.springframework.stereotype.Service;
import vidze.demo.Models.User;

@Service
public class UserService{

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