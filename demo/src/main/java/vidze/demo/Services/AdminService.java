package vidze.demo.Services;

import vidze.demo.Forms.Requests.RemovePromoterRequest;
import vidze.demo.Forms.Responses.StatusResponse;
import vidze.demo.Models.Admin;
import vidze.demo.Models.Promoter;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.status.Status;
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

    public ResponseEntity<StatusResponse> removePromoter(RemovePromoterRequest request){
        Optional<Promoter> p = promoter_repo.findPromoterByEmail(request.getEmail());

        if(!p.isPresent()) return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                                .body(StatusResponse.builder()
                                                .status("Promoter doesn't exist")
                                                .build());

        this.promoter_repo.delete(p.get());
        return ResponseEntity.ok(StatusResponse.builder()
                             .status("ok")
                             .build());
    }
}
