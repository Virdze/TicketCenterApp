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
    
    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<Event> events;

    public Location(int id, String name, String address, int capacity, String map){
        this.id = id;
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.map = map;
    }


    public String getName() {
        return this.name;
    }
    public String getAddress() {
        return this.address;
    }
    public int getCapacity() {
        return this.capacity;
    }
    public String getMap() {
        return this.map;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setMap(String map) {
        this.map = map;
    }

}
