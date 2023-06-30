package vidze.demo.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "artist_in_event")
public class ArtistInEvent {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "artist_list", referencedColumnName = "id")
    private Artist artist;

    @ManyToOne
    @JoinColumn(name = "event_list", referencedColumnName = "id")
    private Event event;


    public ArtistInEvent(int id, Artist artist, Event event) {
        this.id = id;
        this.artist = artist;
        this.event = event;
    }


    public Artist getArtist() {
        return this.artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Event getEvent() {
        return this.event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

}
