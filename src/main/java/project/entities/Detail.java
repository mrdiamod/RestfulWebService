package project.entities;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="details")
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String detailname;
    private long power;
    private String units;
    private long price;
    
    @ManyToMany
    @JoinTable(name = "details_users",
            joinColumns = {@JoinColumn(name = "detail_id")},
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> details_usersList;

    public Set<User> getDetails_usersLists() {
        return details_usersList;
    }

    public void setDetails_usersLists(Set<User> details_usersList) {
        this.details_usersList = details_usersList;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDetailname() {
        return detailname;
    }

    public void setDetailname(String detailname) {
        this.detailname = detailname;
    }
    
    public long getPower() {
        return power;
    }

    public void setPower(long power) {
        this.power = power;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }
    
    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
    
    protected Detail(){}
    public Detail(String name, long powerV, String unitsV, long priceB) {
    	detailname = name;
    	power = powerV;
    	units = unitsV;
    	price = priceB;
    }
    
    
}