package vidze.demo.Models;

import java.time.LocalDateTime;

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


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event;


    public Ticket(int id, String type, float price, float type_cost){
        this.id = id;
        this.type = type;
        this.price = price;
        this.type_cost = type_cost;
    }

    public String getType() {
        return this.type;
    }
    public float getPrice() {
        return this.price;
    }
    public float getType_cost() {
        return this.type_cost;
    }

    public void setType(String type) {
        this.type = type;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public void setType_cost(float type_cost) {
        this.type_cost = type_cost;
    }

}
