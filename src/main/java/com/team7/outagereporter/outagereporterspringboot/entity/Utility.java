package com.team7.outagereporter.outagereporterspringboot.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "utility")
public class Utility {

    @Id
    @GeneratedValue(generator = "utility_seq")
    @Column(name = "utility_id")
    private Long utilityId;

    @OneToMany(mappedBy = "utility")
    private Set<UtilityArea> utilityAreas;

    private String name;
    private String email;
    private String website;

    public Utility(){}

    public Utility(String name, String email, String website) {
        this.name = name;
        this.email = email;
        this.website = website;
    }

    public Utility(String name, Set<UtilityArea> utilityAreas, String email, String website) {
        this.name = name;
        this.utilityAreas = utilityAreas;
        this.email = email;
        this.website = website;
    }

    public void setUtilityId(long utilityId){
        this.utilityId = utilityId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUtilityAreas(Set<UtilityArea> utilityAreas) {
        this.utilityAreas = utilityAreas;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setWebsite(String website){
        this.website = website;
    }

    public Long getUtilityId(){
        return utilityId;
    }

    public String getName() {
        return name;
    }

    public Set<UtilityArea> getUtilityArea(Set<UtilityArea> utilityArea) {
        return this.utilityAreas = utilityArea;
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
                "utilityId=" + utilityId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", website='" + website + '\'' +
                '}';
    }
}
