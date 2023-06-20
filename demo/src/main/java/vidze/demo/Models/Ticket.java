package vidze.demo.Models;

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

    @Column(name = "price")
    private float price;

    @Column(name = "range")
    private float range;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event;


    public Ticket(int id, String type, float price, float range){
        this.id = id;
        this.type = type;
        this.price = price;
        this.range = range;
    }

    public String getType() {
        return this.type;
    }
    public float getPrice() {
        return this.price;
    }
    public float getRange() {
        return this.range;
    }

    public void setType(String type) {
        this.type = type;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public void setRange(float range) {
        this.range = range;
    }

}
