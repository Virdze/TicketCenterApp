package vidze.demo.Forms.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterPromoterRequest {
    private String email;
    private String password;
    private String name;
}
