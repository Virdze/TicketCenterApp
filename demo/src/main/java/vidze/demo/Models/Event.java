package vidze.demo.Models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


public class Event {
    
    private int id;
    private String name;
    private LocalDateTime date;
    private String duration;
    private boolean accepted;
    private Location location;
    private Map<Integer, Artist> artists;
    private Map<Integer, User> followers;
    private Map<Integer, Ad> ads;
    private Map<Integer, Ticket> tickets;
    


    public Event(int id, String name, LocalDateTime date, String duration, boolean accepted, Location location, Map<Integer,Artist> artists, Map<Integer,User> followers, Map<Integer,Ad> ads, Map<Integer,Ticket> tickets) {
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
    public Map<Integer,Artist> getArtists() {
        return this.artists;
    }
    public Map<Integer,User> getFollowers() {
        return this.followers;
    }
    public Map<Integer,Ad> getAds() {
        return this.ads;
    }
    public Map<Integer,Ticket> getTickets() {
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
    public void setArtists(Map<Integer,Artist> artists) {
        this.artists = artists;
    }
    public void setFollowers(Map<Integer,User> followers) {
        this.followers = followers;
    }
    public void setAds(Map<Integer,Ad> ads) {
        this.ads = ads;
    }
    public void setTickets(Map<Integer,Ticket> tickets) {
        this.tickets = tickets;
    }
}
