package vidze.demo.Models;

import java.time.LocalDateTime;
import java.util.List;


import jakarta.persistence.*;

@Entity
@Table(name = "events")
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


    public Event(int id, String name, LocalDateTime date_start, LocalDateTime date_end, boolean accepted, String image, Location location, List<ArtistInEvent> artists, List<EventFollowed> users_following, List<EventSaved> users_saved, List<Ad> ads, List<Ticket> tickets, Promoter promoter, Admin admin) {
        this.id = id;
        this.name = name;
        this.date_start = date_start;
        this.date_end = date_end;
        this.accepted = accepted;
        this.image = image;
        this.location = location;
        this.artists = artists;
        this.users_following = users_following;
        this.users_saved = users_saved;
        this.ads = ads;
        this.tickets = tickets;
        this.promoter = promoter;
        this.admin = admin;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDate_start() {
        return this.date_start;
    }

    public void setDate_start(LocalDateTime date_start) {
        this.date_start = date_start;
    }

    public LocalDateTime getDate_end() {
        return this.date_end;
    }

    public void setDate_end(LocalDateTime date_end) {
        this.date_end = date_end;
    }

    public boolean isAccepted() {
        return this.accepted;
    }

    public boolean getAccepted() {
        return this.accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<ArtistInEvent> getArtists() {
        return this.artists;
    }

    public void setArtists(List<ArtistInEvent> artists) {
        this.artists = artists;
    }

    public List<EventFollowed> getUsers_following() {
        return this.users_following;
    }

    public void setUsers_following(List<EventFollowed> users_following) {
        this.users_following = users_following;
    }

    public List<EventSaved> getUsers_saved() {
        return this.users_saved;
    }

    public void setUsers_saved(List<EventSaved> users_saved) {
        this.users_saved = users_saved;
    }

    public List<Ad> getAds() {
        return this.ads;
    }

    public void setAds(List<Ad> ads) {
        this.ads = ads;
    }

    public List<Ticket> getTickets() {
        return this.tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Promoter getPromoter() {
        return this.promoter;
    }

    public void setPromoter(Promoter promoter) {
        this.promoter = promoter;
    }

    public Admin getAdmin() {
        return this.admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }


}
