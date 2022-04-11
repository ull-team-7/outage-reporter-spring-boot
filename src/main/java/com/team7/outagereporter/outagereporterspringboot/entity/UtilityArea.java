package com.team7.outagereporter.outagereporterspringboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.jshell.execution.Util;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class UtilityArea implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "utilityArea")
    private Set<Utility> utilities = new HashSet<>();

    private int zipCode;
    private int fixTime;
    private String comment;

    public UtilityArea(){}

    public UtilityArea (int zipCode,int fixTime,String comment){
        this.zipCode = zipCode;
        this.fixTime = fixTime;
        this.comment = comment;
    }


    @Override
    public String toString(){
        return "UtilityArea{" +
                "Id = " + id + '\'' +
                "ZipCode = " + zipCode + '\'' +
                "Time to fix = " + fixTime + '\'' +
                "Comment = " + comment + '\'' +
                '}';
    }

    public Set<Utility> getUtilities() {
        return utilities;
    }



    public void setUtilityAreaId(Long id) {this.id = id;}
    public void setZipCode(int zipCode){
        this.zipCode = zipCode;
    }
    public void setTimeToFix(int fixTime){
        this.fixTime = fixTime;
    }
    public void setComment(String comment){
        this.comment = comment;
    }

    public Long getUtilityAreaId() { return id; }
    public int getZipCode(){
        return zipCode;
    }
    public int getTimeToFix(){
        return fixTime;
    }
    public String getComment(){
        return comment;
    }
}
