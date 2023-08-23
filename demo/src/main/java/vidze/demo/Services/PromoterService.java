package vidze.demo.Services;

import vidze.demo.Models.Promoter;
import vidze.demo.Models.Role;
import vidze.demo.Repositories.PromoterRepo;
import vidze.demo.Forms.Requests.*;
import vidze.demo.Forms.Responses.AuthenticationResponse;
import vidze.demo.Forms.Responses.StatusResponse;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PromoterService {
    
    private final PromoterRepo promoter_repo;

    public List<Promoter> getPromoters() {
        return promoter_repo.findAll();
    }
    
    public ResponseEntity<StatusResponse> registerPromoter(RegisterPromoterRequest request){
    
        Optional<Promoter> p = promoter_repo.findPromoterByEmail(request.getEmail());
        if(p.isPresent()) return ResponseEntity.status(HttpStatus.CONFLICT)
                                               .body(StatusResponse.builder()
                                               .status("Promoter already exists")
                                               .build());

        var promoter = Promoter.builder()
                       .name(request.getName())
                       .email(request.getEmail())
                       .password(request.getPassword())
                       .role(Role.PROMOTER)
                       .language("english").build();
        
        this.promoter_repo.save(promoter);

        return ResponseEntity.ok(StatusResponse.builder()
                             .status("ok")
                             .build()); 
    } 

    public ResponseEntity<AuthenticationResponse> loginPromoter(LoginRequest request){

        Optional<Promoter> p = promoter_repo.findPromoterByEmail(request.getEmail());

        if(p.isPresent()) return ResponseEntity.ok(AuthenticationResponse.builder()
                                               .status("ok")
                                               .build());
        else return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                                  .body(AuthenticationResponse.builder()
                                  .status("Invalid Credentials")
                                  .build());        
    }

}
