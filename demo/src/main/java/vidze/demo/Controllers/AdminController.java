package vidze.demo.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import vidze.demo.Forms.Requests.LoginAdminRequest;
import vidze.demo.Forms.Requests.LoginRequest;
import vidze.demo.Forms.Requests.RemovePromoterRequest;
import vidze.demo.Forms.Responses.AuthenticationResponse;
import vidze.demo.Forms.Responses.StatusResponse;
import vidze.demo.Models.Admin;
import vidze.demo.Models.Promoter;
import vidze.demo.Models.User;
import vidze.demo.Services.AdminService;
import vidze.demo.Services.AuthenticationService;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/admin")
@CrossOrigin
public class AdminController {

    private final AdminService adminService;
    private final AuthenticationService authenticationService;

    @GetMapping("/getAdmins")
    public List<Admin> getAdmins(){
        return adminService.getAdmins();
    }
    
    @GetMapping("/getPromoters")
    public List<Promoter> getPromoters(){
        return adminService.getPromoters();
    }

    @GetMapping("/getUsers")
    public List<User> getUsers(){
        return adminService.getUsers();
    }

    @PostMapping("/removePromoter")
    public ResponseEntity<StatusResponse> removePromoter(@RequestBody RemovePromoterRequest request){
        return adminService.removePromoter(request);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> loginPromoter(@RequestBody LoginAdminRequest request){
        return authenticationService.login_admin(request);
    }
    
}
