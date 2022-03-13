package com.team7.outagereporter.outagereporterspringboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Utility {
    @Id
    @GeneratedValue
    private long utilityId;

    private String email;
    private String website;

    public Utility(){}

    public void setUtilityId(long utilityId){
        this.utilityId = utilityId;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setWebsite(String website){
        this.website = website;
    }
    public long getUtilityId(){
        return utilityId;
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
                "UtilityId = " + utilityId + '\'' +
                "Email = " + email + '\'' +
                "Website = " + website + '\'' +
                '}';
    }
}
