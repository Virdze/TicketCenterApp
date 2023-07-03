package vidze.demo.Models;

import java.io.Serializable;
import java.time.LocalDateTime;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "ad")
public class Ad implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "ticket")
    private String ticket;

    @Column(name = "price")
    private float price;

    @Column(name = "sold")
    private boolean sold;

    @Column(name = "descripiton")
    private String description;

    @ManyToOne
    @JoinColumn(name = "ticket_type_id", referencedColumnName = "id")
    private Ticket ticket_type;

    @ManyToOne
    @JoinColumn(name = "buyer_id", referencedColumnName = "id")
    private User buyer;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event;

}
