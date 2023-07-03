package vidze.demo.Models;

import java.time.LocalDateTime;
import java.util.List;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "event")
public class Event {
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "date_start")
    private LocalDateTime date_start;

    @Column(name = "date_end")
    private LocalDateTime date_end;

    @Column(name = "accepted")
    private boolean accepted;

    @Column(name = "image")
    private String image;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;
    
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<ArtistInEvent> artists;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<EventFollowed> users_following;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<EventSaved> users_saved;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Ad> ads;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Ticket> tickets;
    
    @ManyToOne
    @JoinColumn(name = "promoter_id", referencedColumnName = "id")
    private Promoter promoter;

    @ManyToOne
    @JoinColumn(name = "admin_id", referencedColumnName = "id")
    private Admin admin;

}
