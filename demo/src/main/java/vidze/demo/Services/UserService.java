package vidze.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.var;
import vidze.demo.Forms.Requests.RegiserUserRequest;
import vidze.demo.Models.Role;
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

        

        var user = User.builder()
                       .name(request.getName())
                       .age(request.getAge())
                       .email(request.getEmail())
                       .password(request.getPassword())
                       .phone(request.getPhone())
                       .role(Role.USER)
                       .language("english").build();
        
        this.user_repo.save(user);
    }

}