package vidze.demo.Models;

import java.io.Serializable;
import java.util.Map;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "age")
    private int age;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private int phone;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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
