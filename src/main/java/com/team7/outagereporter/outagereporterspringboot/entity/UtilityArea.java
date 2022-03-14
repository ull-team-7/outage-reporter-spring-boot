package com.team7.outagereporter.outagereporterspringboot.entity;

import jdk.jshell.execution.Util;

import javax.persistence.*;

import java.io.Serializable;

@Entity
public class UtilityArea implements Serializable {
    @Id
    @GeneratedValue
    @ManyToOne
    private Utility utilityId;

    @Id
    private int zipCode;

    private int fixTime;
    private String comment;

    public void setUtilityId(Utility utilityId){
        this.utilityId = utilityId;
    }
    public void setZipCode(int zipCode){
        this.zipCode = zipCode;
    }
    public void setTimeToFix(int fixTime){
        this.fixTime = fixTime;
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
        return fixTime;
    }
    public String getComment(){
        return comment;
    }

    @Override
    public String toString(){
        return "UtilityArea{" +
                "UtilityId = " + utilityId + '\'' +
                "ZipCode = " + zipCode + '\'' +
                "Time to fix = " + fixTime + '\'' +
                "Comment = " + comment + '\'' +
                '}';
    }
}
