package vidze.demo.Controllers;

import vidze.demo.Forms.Requests.RegisterPromoterRequest;
import vidze.demo.Forms.Responses.AuthenticationResponse;
import vidze.demo.Forms.Responses.StatusResponse;
import vidze.demo.Forms.Requests.LoginRequest;
import vidze.demo.Services.PromoterService;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/promoter")
public class PromoterController {
    
    private final PromoterService promoterService;    

    @PostMapping("/registerPromoter")
    public ResponseEntity<StatusResponse> registerPromoter(@RequestBody RegisterPromoterRequest request) {
        return promoterService.registerPromoter(request);
    }

    @PostMapping("/loginPromoter")
    public ResponseEntity<AuthenticationResponse> loginPromoter(@RequestBody LoginRequest request){
        return promoterService.loginPromoter(request);
    }

}
