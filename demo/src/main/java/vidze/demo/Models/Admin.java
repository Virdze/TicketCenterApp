package vidze.demo.Models;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "admin")
public class Admin {
    
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

    @Column(name = "role")
    private Role role;
    
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Event> events;

    
}
