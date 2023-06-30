package vidze.demo.Models;

import java.io.Serializable;
import java.time.LocalDateTime;


import jakarta.persistence.*;


@Entity
@Table(name = "ads")
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


    public Ad(int id, LocalDateTime date, String ticket, float price, boolean sold, String description, Ticket ticket_type, User buyer, User user, Event event) {
        this.id = id;
        this.date = date;
        this.ticket = ticket;
        this.price = price;
        this.sold = sold;
        this.description = description;
        this.ticket_type = ticket_type;
        this.buyer = buyer;
        this.user = user;
        this.event = event;
    }


    public LocalDateTime getDate() {
        return this.date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getTicket() {
        return this.ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isSold() {
        return this.sold;
    }

    public boolean getSold() {
        return this.sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Ticket getTicket_type() {
        return this.ticket_type;
    }

    public void setTicket_type(Ticket ticket_type) {
        this.ticket_type = ticket_type;
    }

    public User getBuyer() {
        return this.buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
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
