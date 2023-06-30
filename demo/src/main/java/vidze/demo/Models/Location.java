package vidze.demo.Models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "locations")
public class Location {
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "map")
    private String map;
    
    @Column(name = "city")
    private String city;
    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<Event> events;


    public Location(int id, String name, String address, int capacity, String map, String city, List<Event> events) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.map = map;
        this.city = city;
        this.events = events;
    }
    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getMap() {
        return this.map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Event> getEvents() {
        return this.events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
    

}
