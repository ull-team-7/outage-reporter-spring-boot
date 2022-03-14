package com.team7.outagereporter.outagereporterspringboot.entity;

import jdk.jshell.execution.Util;

import javax.persistence.*;

@Entity
public class UtilityArea {
    @ManyToOne
    private Utility utilityId;

    @Id
    private int zipCode;

    private int timeToFix;
    private String comment;

    public void setUtilityId(Utility utilityId){
        this.utilityId = utilityId;
    }
    public void setZipCode(int zipCode){
        this.zipCode = zipCode;
    }
    public void setTimeToFix(int timeToFix){
        this.timeToFix = timeToFix;
    }
    public void setComment(String comment){
        this.comment = comment;
    }
    public Utility getUtilityId(){
        return utilityId;
    }
    public int getZipCode(){
        return zipCode;
    }
    public int getTimeToFix(){
        return timeToFix;
    }
    public String getComment(){
        return comment;
    }

    @Override
    public String toString(){
        return "UtilityArea{" +
                "UtilityId = " + utilityId + '\'' +
                "ZipCode = " + zipCode + '\'' +
                "Time to fix = " + timeToFix + '\'' +
                "Comment = " + comment + '\'' +
                '}';
    }
}
