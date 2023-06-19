package vidze.demo.Models;

import java.util.Map;

public class Promoter {
    
    private int id;
    private String name;
    private String password;
    private Map<Integer, Event> events;


    public Promoter(int id, String name, String password, Map<Integer, Event> events) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.events = events;

    }



    public String getName() {
        return this.name;
    }
    public String getPassword() {
        return this.password;
    }
    public Map<Integer, Event> getEvents() {
        return this.events;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEvents(Map<Integer, Event> events) {
        this.events = events;
    }

}
