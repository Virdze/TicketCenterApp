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
import vidze.demo.Models.*;
import vidze.demo.Repositories.UserRepo;

@Service
@RequiredArgsConstructor
public class UserService{

    private final UserRepo user_repo;

    public ResponseEntity<String> removeUser(RemoveUserRequest request){
        Optional<User> u = user_repo.findUserByEmail(request.getEmail());

        if(u.isPresent()){
            this.user_repo.delete(u.get());
            return ResponseEntity.ok("{\"status\" : \"ok\"}");
        }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                  .body("{\"status\" : \"User doesn't exist.\"}");
    }

}