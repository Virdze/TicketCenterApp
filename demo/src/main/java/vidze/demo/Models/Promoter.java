package vidze.demo.Models;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "promoters")
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



    public Promoter(int id, String name, String email, String password, String language, Role role, List<Event> events) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.language = language;
        this.role = role;
        this.events = events;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Event> getEvents() {
        return this.events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
    

}
