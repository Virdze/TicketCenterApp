package vidze.demo.Models;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "promoter")
public class Promoter {
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "language")
    private String language;

    @Column(name = "role")
    private Role role;

    @OneToMany(mappedBy = "promoter", cascade = CascadeType.ALL)
    private List<Event> events;


}
