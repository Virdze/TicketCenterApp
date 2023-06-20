package vidze.demo.Models;

import java.io.Serializable;
import java.security.Timestamp;
import java.sql.Time;
import java.time.LocalDateTime;

import org.springframework.data.util.Lazy;

import jakarta.persistence.*;

@Entity
@Table(name = "ad")
public class Ad implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "date")
    private Timestamp date;

    @Column(name = "ticket")
    private String ticket;



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event;


    public Ad(int id, Timestamp date, String ticket){
        this.id = id;
        this.date = date;
        this.ticket = ticket;
    }



    public Timestamp getDate() {
        return this.date;
    }
    public String getTicket() {
        return this.ticket;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

}
