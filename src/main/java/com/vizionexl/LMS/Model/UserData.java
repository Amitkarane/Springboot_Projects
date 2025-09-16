package com.vizionexl.LMS.Model;


import jakarta.persistence.*;

@Table(name="user_data")
@Entity
public class UserData {

    @Id
    @Column(name="user_id")

    private Long id;

    @Column(name="name")
    private String UserName;

    public UserData(){ }

    public UserData(Long id, String userName) {
        this.id = id;
        UserName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }
}
