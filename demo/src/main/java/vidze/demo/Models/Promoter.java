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

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "promoter", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Event> events;


    public Promoter(int id, String name, String password, List<Event> events) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.events = events;

    }



    public String getName() {
        return this.name;
    }
    public String getPassword() {
        return this.password;
    }
    public List<Event> getEvents() {
        return this.events;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEvents(List<Event> events) {
        this.events = events;
    }

}
