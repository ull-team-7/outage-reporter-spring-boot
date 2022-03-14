package com.team7.outagereporter.outagereporterspringboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Utility {

    @Id
    @GeneratedValue(generator = "utility_seq")
    private Long utilityId;

    private String name;
    private String email;
    private String website;

    public Utility(){}

    public Utility(String name, String email, String website) {
        this.name = name;
        this.email = email;
        this.website = website;
    }

    public void setUtilityId(long utilityId){
        this.utilityId = utilityId;
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
        return utilityId;
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
                "utilityId=" + utilityId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", website='" + website + '\'' +
                '}';
    }
}
