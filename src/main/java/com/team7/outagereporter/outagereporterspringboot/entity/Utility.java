package com.team7.outagereporter.outagereporterspringboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "utility")
public class Utility {

    @Id
    @GeneratedValue(generator = "utility_seq")
    @Column(name = "utility_id")
    private Long utilityId;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "utility_id", referencedColumnName = "utility_id", nullable = false)
    private Set<UtilityArea> utilityAreas = new HashSet<>();

    private String name;
    private String email;
    private String website;

    public Utility(){}

    public Utility(String name, String email, String website) {
        this.name = name;
        this.email = email;
        this.website = website;
    }

    public Utility(Set<UtilityArea> utilityAreas, String name, String email, String website) {
        this.utilityAreas = utilityAreas;
        this.name = name;
        this.email = email;
        this.website = website;
    }

    public Long getUtilityId(){
        return utilityId;
    }
    public Set<UtilityArea> getUtilityAreas() {
        return utilityAreas;
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
    public void setUtilityId(long utilityId){
        this.utilityId = utilityId;
    }
    public void setUtilityAreas(Set<UtilityArea> utilityAreas) {
        this.utilityAreas = utilityAreas;
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

    @Override
    public String toString(){
        return "Utility{" +
                "utilityId=" + utilityId +
                ", utilityAreas='" + utilityAreas + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", website='" + website + '\'' +
                '}';
    }
}
