package vidze.demo.Models;

public class Ticket {
    
    private int id;
    private String type;
    private float price;
    private float range;


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
