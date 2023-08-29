package vidze.demo.Controllers;

import vidze.demo.Forms.Requests.RegisterPromoterRequest;
import vidze.demo.Forms.Responses.AuthenticationResponse;
import vidze.demo.Forms.Responses.StatusResponse;
import vidze.demo.Forms.Requests.LoginRequest;
import vidze.demo.Services.AuthenticationService;
import vidze.demo.Services.PromoterService;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/promoter")
@CrossOrigin
public class PromoterController {
    
    private final PromoterService promoterService;
    private final AuthenticationService authenticationService; 

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> registerPromoter(@RequestBody RegisterPromoterRequest request) {
        return authenticationService.register_promoter(request);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> loginPromoter(@RequestBody LoginRequest request){
        return authenticationService.login_promoter(request);
    }

}
