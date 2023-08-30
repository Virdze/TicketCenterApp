package vidze.demo.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import vidze.demo.Services.AuthenticationService;
import vidze.demo.Services.UserService;
import java.util.List;

import vidze.demo.Forms.Requests.*;
import vidze.demo.Forms.Responses.*;
import vidze.demo.Models.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/user")
@CrossOrigin
public class UserController {

    private final AuthenticationService authenticationService;
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> registerUser(@RequestBody RegisterUserRequest request){
        return authenticationService.register_user(request);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest request){
        return authenticationService.login_user(request);
    }

    @PostMapping("/remove")
    public ResponseEntity<String> removeUser(@RequestBody RemoveUserRequest request){
        return userService.removeUser(request);
    }


}