package com.team7.outagereporter.outagereporterspringboot.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="utility_area")
public class UtilityArea implements Serializable {

    @Id
    private String zipCode;
    private Boolean outageStatus;
    private String fixTime;
    private String comment;

    public UtilityArea() {}

    public UtilityArea(String zipCode, Boolean outageStatus, String fixTime, String comment) {
        this.zipCode = zipCode;
        this.outageStatus = outageStatus;
        this.fixTime = fixTime;
        this.comment = comment;
    }

    public String getZipCode() {
        return zipCode;
    }
    public Boolean getOutageStatus() {
        return outageStatus;
    }
    public String getFixTime(){
        return fixTime;
    }
    public String getComment(){
        return comment;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public void setOutageStatus(Boolean outageStatus) {
        this.outageStatus = outageStatus;
    }
    public void setFixTime(String fixTime){
        this.fixTime = fixTime;
    }
    public void setComment(String comment){
        this.comment = comment;
    }

    @Override
    public String toString(){
        return "UtilityArea{" +
                "zipCode=" + zipCode +
                ", outageStatus=" + outageStatus +
                ", fixTime=" + fixTime +
                ", comment=" + comment +
                '}';
    }
}
