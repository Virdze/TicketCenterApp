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

    @OneToMany(mappedBy = "promoter", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Event> events;


    public Promoter(int id, String name, String email, String password, String language, List<Event> events) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.language = language;
        this.events = events;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Event> getEvents() {
        return this.events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

}
