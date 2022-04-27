package com.team7.outagereporter.outagereporterspringboot.entity;

import javax.persistence.*;

@Entity
@Table(name="outage")
public class Outage {

    @Id
    @GeneratedValue(generator = "Outage_seq")
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "utility_id", referencedColumnName = "utility_id")
    private Utility utility;

    private String firstName;
    private String lastName;
    private String streetAddress;
    private String zipCode;
    private String email;
    private String comment;

    public Outage() {}

    public Outage(String firstName, String lastName, String streetAddress, String zipCode, String email, String comment, Utility utility) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.zipCode = zipCode;
        this.email = email;
        this.comment = comment;
        this.utility = utility;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Utility getUtility() {
        return utility;
    }
    public void setUtility(Utility utility) {
        this.utility = utility;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getStreetAddress() {
        return streetAddress;
    }
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Outage{" +
                "id=" + id +
                ", utility='" + utility + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", email='" + email + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
