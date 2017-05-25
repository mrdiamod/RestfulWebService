package project.entities;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="shemes")
public class ShemeDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String shemename;
    private String information;
    
    @ManyToMany
    @JoinTable(name = "shemes_details",
            joinColumns = {@JoinColumn(name = "sheme_id")},
            inverseJoinColumns = @JoinColumn(name = "detail_id"))
    private Set<Detail> shemes_detailsList;

    public Set<Detail> getShemes_DetailsList() {
        return shemes_detailsList;
    }

    public void setShemes_DetailsList(Set<Detail> shemes_detailsList) {
        this.shemes_detailsList = shemes_detailsList;
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

    protected ShemeDetail(){}
    public ShemeDetail(String name, String info) {
        shemename = name;
        information = info;
    }
    
}