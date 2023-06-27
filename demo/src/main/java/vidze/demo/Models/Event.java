package vidze.demo.Models;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.cglib.core.Local;

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

    @Column(name = "duration")
    private String duration;

    @Column(name = "accepted")
    private boolean accepted;

    @Column(name = "image")
    private String image;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;
    
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Artist> artists;

    //Ver como funciona com padrao observer
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<User> followers;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ad> ads;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ticket> tickets;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "promoter_id", referencedColumnName = "id")
    private Promoter promoter;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "admin_id", referencedColumnName = "id")
    private Admin admin;

    

    public Event(int id, String name, LocalDateTime date_start, LocalDateTime date_end, String duration, boolean accepted, String image, Location location, List<Artist> artists, List<User> followers, List<Ad> ads, List<Ticket> tickets, Promoter promoter, Admin admin) {
        this.id = id;
        this.name = name;
        this.date_start = date_start;
        this.date_end = date_end;
        this.duration = duration;
        this.accepted = accepted;
        this.image = image;
        this.location = location;
        this.artists = artists;
        this.followers = followers;
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

    public String getDuration() {
        return this.duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
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

    public List<Artist> getArtists() {
        return this.artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public List<User> getFollowers() {
        return this.followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
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
