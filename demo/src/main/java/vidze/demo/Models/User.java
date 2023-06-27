package vidze.demo.Models;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
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

    @Column(name = "role")
    private Role role;

    @Column(name = "language")
    private String language;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ad> ads;

    public User(){}
    public User(int id, int age, String name, String email, String password, int phone, List<Ad> ads) {
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
    public List<Ad> getAds() {
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
    public void setAds(List<Ad> ads) {
        this.ads = ads;
    }

    

    
}
