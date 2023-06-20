package vidze.demo.Models;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "admins")
public class Admin {

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;
    
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Event> events;

    public Admin(String name, String password, List<Event> events) {
        this.name = name;
        this.password = password;
        this.events = events;
    }


    public String getName() {
        return this.name;
    }
    public List<Event> getEvents() {
        return this.events;
    }
    public String getPassword() {
        return this.password;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setEvents(List<Event> events) {
        this.events = events;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
