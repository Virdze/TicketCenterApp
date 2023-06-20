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

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "duration")
    private String duration;

    @Column(name = "accepted")
    private boolean accepted;



    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private Location location;
    
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Artist> artists;

    //Ver como funciona com padrao observer
    private List<User> followers;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ad> ads;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ticket> tickets;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "promoter_id", referencedColumnName = "id")
    private Promoter promoter;
    

    public Event(int id, String name, LocalDateTime date, String duration, boolean accepted, Location location, List<Artist> artists, List<User> followers, List<Ad> ads, List<Ticket> tickets) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.duration = duration;
        this.accepted = accepted;
        this.location = location;
        this.artists = artists;
        this.followers = followers;
        this.ads = ads;
        this.tickets = tickets;
    }
   

    public String getName() {
        return this.name;
    }

    
    public LocalDateTime getDate() {
        return this.date;
    }
    public String getDuration() {
        return this.duration;
    }
    public boolean getAccepted() {
        return this.accepted;
    }
    public Location getLocation() {
        return this.location;
    }
    public List<Artist> getArtists() {
        return this.artists;
    }
    public List<User> getFollowers() {
        return this.followers;
    }
    public List<Ad> getAds() {
        return this.ads;
    }
    public List<Ticket> getTickets() {
        return this.tickets;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }
    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }
    public void setAds(List<Ad> ads) {
        this.ads = ads;
    }
    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
