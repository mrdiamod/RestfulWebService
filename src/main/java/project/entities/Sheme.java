package project.entities;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="shemes")
public class Sheme {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String shemename;
    private String information;
    
    @ManyToMany
    @JoinTable(name = "shemes_users",
            joinColumns = {@JoinColumn(name = "sheme_id")},
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> shemes_usersList;

    public Set<User> getShemes_usersList() {
        return shemes_usersList;
    }

    public void setShemes_usersList(Set<User> shemes_usersList) {
        this.shemes_usersList = shemes_usersList;
    }
    
    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShemename() {
        return shemename;
    }

    public void setShemename(String shemename) {
        this.shemename = shemename;
    }

    protected Sheme(){}
    public Sheme(String name, String info) {
        shemename = name;
        information = info;
    }
    
}