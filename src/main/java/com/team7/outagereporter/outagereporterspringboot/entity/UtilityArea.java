package com.team7.outagereporter.outagereporterspringboot.entity;

import com.team7.outagereporter.outagereporterspringboot.service.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

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

        public Pk() {}

        public Pk(String zipCode, Long utilityId) {
            this.zipCode = zipCode;
            this.utilityId = utilityId;
        }

        public String getZipCode() {
            return zipCode;
        }
        public Long getUtilityId() {
            return utilityId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pk)) return false;
            Pk pk = (Pk) o;
            return zipCode.equals(pk.zipCode) && utilityId.equals(pk.utilityId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(zipCode, utilityId);
        }

        @Override
        public String toString(){
            return "Pk{" +
                    "ZipCode = " + zipCode + '\'' +
                    "UtilityId = " + utilityId + '\'' +
                    '}';
        }
    }

    @EmbeddedId
    private Pk id;

    @ManyToOne
    @JoinColumn(name = "utility_id", nullable = false)
    private Utility utility;

    private String fixTime;
    private String comment;

    public UtilityArea() {}

    public UtilityArea(String zipCode, Long utilityId, String fixTime, String comment) {
        this.id = new Pk(zipCode, utilityId);
        this.fixTime = fixTime;
        this.comment = comment;
    }

    public UtilityArea(String zipCode, Long utilityId, Utility utility, String fixTime, String comment) {
        this.id = new Pk(zipCode, utilityId);
        this.utility = utility;
        this.fixTime = fixTime;
        this.comment = comment;
    }

    public void setZipCode(String zipCode){
        this.id.zipCode = zipCode;
    }
    public void setUtilityId(Long utilityId) {
        this.id.utilityId = utilityId;
    }
    public void setUtilityAreaId(Pk id) {
        this.id = id;
    }
    public void setUtility(Utility utility){
        this.utility = utility;
    }
    public void setTimeToFix(String fixTime){
        this.fixTime = fixTime;
    }
    public void setComment(String comment){
        this.comment = comment;
    }
    public String getZipCode(){
        return id.zipCode;
    }
    public Long getUtilityId() {
        return id.utilityId;
    }
    public Pk getUtilityAreaId() {
        return id;
    }
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
        return "UtilityArea{" +
                "ZipCode = " + id.zipCode + '\'' +
                "UtilityId = " + id.utilityId + '\'' +
                "Time to fix = " + fixTime + '\'' +
                "Comment = " + comment + '\'' +
                '}';
    }
}
