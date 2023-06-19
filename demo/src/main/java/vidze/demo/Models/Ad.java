package vidze.demo.Models;

import java.time.LocalDateTime;

public class Ad {
    
    private int id;
    private LocalDateTime date;
    private String ticket;

    public Ad(int id, LocalDateTime date, String ticket){
        this.id = id;
        this.date = date;
        this.ticket = ticket;
    }



    public LocalDateTime getDate() {
        return this.date;
    }
    public String getTicket() {
        return this.ticket;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

}
