package vidze.demo.Models;

public class Artist {
    
    private int id;
    private String name;

    public Artist(int id, String name){
        this.id = id;
        this.name = name; 
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
