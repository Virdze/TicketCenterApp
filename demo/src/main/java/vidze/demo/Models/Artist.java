package vidze.demo.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "artists")
public class Artist {
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event;

    public Artist(int id, String name){
        this.id = id;
        this.name = name; 
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
