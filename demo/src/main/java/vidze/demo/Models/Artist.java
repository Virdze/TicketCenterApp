package vidze.demo.Models;

import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name = "artists")
public class Artist {
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
    private List<ArtistInEvent> event_list;


    public Artist(int id, String name, List<ArtistInEvent> event_list) {
        this.id = id;
        this.name = name;
        this.event_list = event_list;
    }
    

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ArtistInEvent> getEvent_list() {
        return this.event_list;
    }

    public void setEvent_list(List<ArtistInEvent> event_list) {
        this.event_list = event_list;
    }


}
