package com.team7.outagereporter.outagereporterspringboot.entity;

import javax.persistence.*;

@Entity
public class Utility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "utilityArea_id",referencedColumnName = "id")
    private UtilityArea utilityArea;

    private String name;
    private String email;
    private String website;

    public Utility(){}

    public Utility(String name, String email, String website) {
        this.name = name;
        this.email = email;
        this.website = website;
    }

    public void setUtilityId(long id){
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setWebsite(String website){
        this.website = website;
    }
    public Long getUtilityId(){
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getWebsite(){
        return website;
    }

    @Override
    public String toString(){
        return "Utility{" +
                "utilityId=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", website='" + website + '\'' +
                '}';
    }

    public UtilityArea getUtilityArea() {
        return utilityArea;
    }

    public void assignUtilityArea(UtilityArea utilityArea) {
        this.utilityArea = utilityArea;
    }
}
