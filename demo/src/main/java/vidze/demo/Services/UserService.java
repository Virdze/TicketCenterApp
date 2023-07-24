package vidze.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.var;
import vidze.demo.Forms.Requests.*;
import vidze.demo.Models.*;
import vidze.demo.Repositories.UserRepo;

@Service
@RequiredArgsConstructor
public class UserService{

    private final UserRepo user_repo;

    public List<User> getUsers(){
        return user_repo.findAll();
    }

    public List<String> registerUser(RegiserUserRequest request){
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

        return List.of("state","ok");
    }

    public List<String> removeUser(RemoveUserRequest request){
        Optional<User> u = user_repo.findUserByEmail(request.getEmail());

        if(u.isPresent()){
            this.user_repo.delete(u.get());
            return List.of("state","ok");
        }
        else return List.of("state","error");
    }

}