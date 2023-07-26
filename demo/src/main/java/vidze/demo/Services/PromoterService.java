package vidze.demo.Services;

import vidze.demo.Forms.Requests.RegiserUserRequest;
import vidze.demo.Models.Promoter;
import vidze.demo.Models.Role;
import vidze.demo.Repositories.PromoterRepo;
import vidze.demo.Forms.Requests.*;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PromoterService {
    
    private final PromoterRepo promoter_repo;
    
    public List<String> registerPromoter(RegisterPromoterRequest request){
    
        Optional<Promoter> p = promoter_repo.findPromoterByEmail(request.getEmail());
        if(p.isPresent()) return List.of("state","email not valid!");
        var user = Promoter.builder()
                       .name(request.getName())
                       .email(request.getEmail())
                       .password(request.getPassword())
                       .role(Role.PROMOTER)
                       .language("english").build();
        
        this.promoter_repo.save(user);

        return List.of("state","ok");        
    } 

    public List<String> loginPromoter(LoginRequest request){

        Optional<Promoter> p = promoter_repo.findPromoterByEmail(request.getEmail());

        if(p.isPresent()) return List.of("state", "ok");
        else return List.of("state", "user doesn't exist!");
        
    }

}
