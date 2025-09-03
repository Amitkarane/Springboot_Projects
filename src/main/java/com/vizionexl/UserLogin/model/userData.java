package com.vizionexl.UserLogin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Users")
public class userData {

    @Id
    @Column(name="id")
    private Long id;

    @Column(name="first_name", length=50)
    private String firstName;

    @Column(name="last_name", length=50)
    private String lastName;

    @Column(name="mobile_number", length=14)
    private String mobileNumber;

    @Column(name="mail_id", length=100)
    private String mailId;

    @Column(name="password", length=20)
    private String password;

    public userData(){ }

    public userData(Long id, String firstName, String lastName, String mobileNumber, String mailId, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.mailId = mailId;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
