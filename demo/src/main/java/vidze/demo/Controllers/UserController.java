package vidze.demo.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import vidze.demo.Services.UserService;
import java.util.List;

import vidze.demo.Forms.Requests.*;
import vidze.demo.Forms.Responses.*;
import vidze.demo.Models.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/registerUser")
    public List<String> registerUser(@RequestBody RegiserUserRequest request){
        return userService.registerUser(request);
    }

    @PostMapping("/removeUser")
    public List<String> removeUser(@RequestBody RemoveUserRequest request){
        return userService.removeUser(request);
    }

    @GetMapping("/login")
    public List<String> login(@RequestBody LoginRequest request){
        return userService.login(request);
    }

}