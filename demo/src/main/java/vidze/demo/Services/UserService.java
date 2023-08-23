package vidze.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.var;
import vidze.demo.Forms.Requests.*;
import vidze.demo.Forms.Responses.AuthenticationResponse;
import vidze.demo.Forms.Responses.StatusResponse;
import vidze.demo.Models.*;
import vidze.demo.Repositories.UserRepo;

@Service
@RequiredArgsConstructor
public class UserService{

    private final UserRepo user_repo;

    public List<User> getUsers(){
        return user_repo.findAll();
    }

    public ResponseEntity<StatusResponse> registerUser(RegiserUserRequest request){
        Optional<User> u = user_repo.findUserByEmail(request.getEmail());
        if(u.isPresent())
        {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(StatusResponse.builder()
                   .status("User already exists.")
                   .build());
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

        return ResponseEntity.ok(StatusResponse.builder()
               .status("ok")
               .build());
    }

    public ResponseEntity<String> removeUser(RemoveUserRequest request){
        Optional<User> u = user_repo.findUserByEmail(request.getEmail());

        if(u.isPresent()){
            this.user_repo.delete(u.get());
            return ResponseEntity.ok("{\"status\" : \"ok\"}");
        }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                  .body("{\"status\" : \"User doesn't exist.\"}");
    }

    public ResponseEntity<AuthenticationResponse> login(LoginRequest request){
        Optional<User> u = user_repo.findUserByEmail(request.getEmail());

        if(u.isPresent()){
            System.out.println("Got it");
            return ResponseEntity.ok(AuthenticationResponse.builder()
            .status("ok")
            .build());
        }
        else return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                                  .body(AuthenticationResponse.builder()
                                  .status("Invalid Credentials.")
                                  .build());
    }

}