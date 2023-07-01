package vidze.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import vidze.demo.Forms.Requests.RegiserUserRequest;
import vidze.demo.Models.User;
import vidze.demo.Repositories.UserRepo;

@Service
@RequiredArgsConstructor
public class UserService{

    private final UserRepo user_repo;

    public List<User> getUsers(){
        return user_repo.findAll();
    }

    public void registerUser(RegiserUserRequest request){
        Optional<User> u = user_repo.findUserByEmail(request.getEmail());
        if(u.isPresent())
        {
            throw new IllegalStateException("User already exists");
        }

        String name = request.getName();
        String email = request.getEmail();
        String password = request.getPassword();
        int phone = request.getPhone();
        int age = request.getAge();

        //Falta acrescentar o @Data em todos os models das entidades.
        User user = new User();
        user_repo.save(user);
    }

}