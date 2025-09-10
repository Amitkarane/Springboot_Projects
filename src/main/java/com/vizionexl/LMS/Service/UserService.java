package com.vizionexl.LMS.Service;

import com.vizionexl.LMS.DAO.UserRepository;
import com.vizionexl.LMS.Model.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userrepository;

    public List<UserData> GetAllUser(){
        return userrepository.findAll();
    }

    public UserData SaveUser(UserData user){
        return userrepository.save(user);
    }

}
