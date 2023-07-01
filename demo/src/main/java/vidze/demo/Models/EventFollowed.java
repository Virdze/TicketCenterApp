package vidze.demo.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "user_followed_event")
public class EventFollowed {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_id",referencedColumnName = "id")
    private Event event;


    public EventFollowed(int id, User user, Event event) {
        this.id = id;
        this.user = user;
        this.event = event;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return this.event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
    
}
