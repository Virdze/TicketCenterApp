package vidze.demo.Models;

import java.util.Map;

public class User {

    private int id;
    private int age;
    private String name;
    private String email;
    private String password;
    private int phone;
    private Map<Integer,Ad> ads;

    public User(){}
    public User(int id, int age, String name, String email, String password, int phone, Map<Integer,Ad> ads) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.ads = ads;
    }


    /* GETTERS */
    public int getAge() {
        return this.age;
    }
    public String getName() {
        return this.name;
    }
    public String getEmail() {
        return this.email;
    }
    public String getPassword() {
        return this.password;
    }
    public int getPhone() {
        return this.phone;
    }
    public Map<Integer, Ad> getAds() {
        return this.ads;
    }

    
    /* SETTERS */
    public void setAge(int age) {
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }
    public void setAds(Map<Integer, Ad> ads) {
        this.ads = ads;
    }

    

    
}
