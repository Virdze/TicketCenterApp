package vidze.demo.Models;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "ticket")
public class Ticket {
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "type")
    private String type;
    @Column(name = "start_date")
    private LocalDateTime start_date;

    @Column(name = "end_date")
    private LocalDateTime end_date;

    @Column(name = "price")
    private float price;

    @Column(name = "type_cost")
    private float type_cost;


    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event;

    @OneToMany(mappedBy = "ticket_type" , cascade = CascadeType.ALL)
    private List<Ad> ads;


}
