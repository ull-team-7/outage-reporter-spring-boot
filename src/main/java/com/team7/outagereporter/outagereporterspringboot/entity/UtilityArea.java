package com.team7.outagereporter.outagereporterspringboot.entity;

import com.team7.outagereporter.outagereporterspringboot.service.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="utility_area")
public class UtilityArea implements Serializable {

//    @Transient
//    @Autowired
//    private UtilityService utilityService;

    @Embeddable
    public static class Pk implements Serializable {
        private String zipCode;
        private Long utilityId;
    }

    @EmbeddedId
    private Pk id;

    @ManyToOne
    @JoinColumn(name = "utility_id", nullable = false)
    private Utility utility;

    private String fixTime;
    private String comment;

    public UtilityArea() {}

//    public UtilityArea(String zipCode, Utility utility, String fixTime, String comment) {
//        this.zipCode = zipCode;
//        this.utility = utility;
//        this.fixTime = fixTime;
//        this.comment = comment;
//    }

//    public void setZipCode(String zipCode){
//        this.zipCode = zipCode;
//    }
//    public void setUtility(Utility utility){
//        this.utility = utility;
//    }
    public void setTimeToFix(String fixTime){
        this.fixTime = fixTime;
    }
    public void setComment(String comment){
        this.comment = comment;
    }
//    public String getZipCode(){
//        return zipCode;
//    }
    public Utility getUtility(){
        return utility;
    }
    public String getTimeToFix(){
        return fixTime;
    }
    public String getComment(){
        return comment;
    }

    @Override
    public String toString(){
        return "";
//        return "UtilityArea{" +
//                "UtilityId = " + utility + '\'' +
//                "ZipCode = " + zipCode + '\'' +
//                "Time to fix = " + fixTime + '\'' +
//                "Comment = " + comment + '\'' +
//                '}';
    }
}
