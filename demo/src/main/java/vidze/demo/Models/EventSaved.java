package vidze.demo.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user_saved_event")
public class EventSaved {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event;

}