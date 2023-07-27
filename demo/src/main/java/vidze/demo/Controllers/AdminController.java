package vidze.demo.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import vidze.demo.Forms.Requests.RemovePromoterRequest;
import vidze.demo.Models.Admin;
import vidze.demo.Models.Promoter;
import vidze.demo.Services.AdminService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/admin")
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/getAdmins")
    public List<Admin> getAdmins(){
        return adminService.getAdmins();
    }
    
    @GetMapping("/getPromoters")
    public List<Promoter> getPromoters(){
        return adminService.getPromoters();
    }

    @PostMapping("/removePromoter")
    public List<String> removePromoter(@RequestBody RemovePromoterRequest request){
        return adminService.removePromoter(request);
    }
    
}
