package vidze.demo.Controllers;

import vidze.demo.Forms.Requests.RegisterPromoterRequest;
import vidze.demo.Services.PromoterService;

import java.util.List;

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
    public List<String> registerPromoter(@RequestBody RegisterPromoterRequest request) {
        return promoterService.registerPromoter(request);
    }

}
