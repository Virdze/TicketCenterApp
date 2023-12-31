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

}
