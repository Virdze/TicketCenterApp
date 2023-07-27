package vidze.demo.Services;

import vidze.demo.Forms.Requests.RemovePromoterRequest;
import vidze.demo.Models.Admin;
import vidze.demo.Models.Promoter;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import vidze.demo.Repositories.PromoterRepo;
import vidze.demo.Repositories.AdminRepo;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepo admin_repo;
    private final PromoterRepo promoter_repo;

    public List<Admin> getAdmins(){
        return admin_repo.findAll();
    }

    public List<Promoter> getPromoters() {
        return promoter_repo.findAll();
    }

    public List<String> removePromoter(RemovePromoterRequest request){
        Optional<Promoter> p = promoter_repo.findPromoterByEmail(request.getEmail());

        if(!p.isPresent()) return List.of("status","promoter doesn't exist.");

        this.promoter_repo.delete(p.get());
        return List.of("status","ok");
    }
    
}
