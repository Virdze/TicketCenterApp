package vidze.demo.Forms.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegiserUserRequest {
    private String name;
    private String email;
    private String password;
    private int phone;
    private int age;
}
