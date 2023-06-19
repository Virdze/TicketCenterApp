package vidze.demo.Models;

public class Location {
    
    private int id;
    private String name;
    private String address;
    private int capacity;
    private String map;

    public Location(int id, String name, String address, int capacity, String map){
        this.id = id;
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.map = map;
    }


    public String getName() {
        return this.name;
    }
    public String getAddress() {
        return this.address;
    }
    public int getCapacity() {
        return this.capacity;
    }
    public String getMap() {
        return this.map;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setMap(String map) {
        this.map = map;
    }

}
