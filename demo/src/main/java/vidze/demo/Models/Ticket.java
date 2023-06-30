package vidze.demo.Models;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "tickets")
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



    public Ticket(int id, String type, LocalDateTime start_date, LocalDateTime end_date, float price, float type_cost, Event event, List<Ad> ads) {
        this.id = id;
        this.type = type;
        this.start_date = start_date;
        this.end_date = end_date;
        this.price = price;
        this.type_cost = type_cost;
        this.event = event;
        this.ads = ads;
    }


    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getStart_date() {
        return this.start_date;
    }

    public void setStart_date(LocalDateTime start_date) {
        this.start_date = start_date;
    }

    public LocalDateTime getEnd_date() {
        return this.end_date;
    }

    public void setEnd_date(LocalDateTime end_date) {
        this.end_date = end_date;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getType_cost() {
        return this.type_cost;
    }

    public void setType_cost(float type_cost) {
        this.type_cost = type_cost;
    }

    public Event getEvent() {
        return this.event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public List<Ad> getAds() {
        return this.ads;
    }

    public void setAds(List<Ad> ads) {
        this.ads = ads;
    }

}
