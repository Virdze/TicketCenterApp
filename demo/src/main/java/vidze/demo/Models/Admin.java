package vidze.demo.Models;

import java.util.Map;

public class Admin {
    private String name;
    private String password;
    private Map<Integer, Event> events;

    public Admin(String name, String password, Map<Integer, Event> events) {
        this.name = name;
        this.password = password;
        this.events = events;
    }


    public String getName() {
        return this.name;
    }
    public Map<Integer, Event> getEvents() {
        return this.events;
    }
    public String getPassword() {
        return this.password;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setEvents(Map<Integer, Event> events) {
        this.events = events;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
