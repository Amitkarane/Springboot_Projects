package com.vizionexl.LMS.Model;

import jakarta.persistence.*;

@Entity
@Table(name="admin")
public class AdminData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="admin_name")
    private String AdminName;

    @Column(name="mail_id")
    private String mailId;

    @Column(name="password")
    private String password;

    public AdminData(){ }

    public AdminData(int id, String adminName, String mailId, String password) {
        this.id = id;
        AdminName = adminName;
        this.mailId = mailId;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdminName() {
        return AdminName;
    }

    public void setAdminName(String adminName) {
        AdminName = adminName;
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
