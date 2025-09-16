package com.vizionexl.LMS.Service;

import com.vizionexl.LMS.DAO.UserRepository;
import com.vizionexl.LMS.Model.UserData;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userrepository;

    public List<UserData> GetAllUser(){
        return userrepository.findAll(Sort.by(Sort.by(Sort.Direction.ASC,"id").toList()));
    }

    public UserData SaveUser(UserData user){
        return userrepository.save(user);
    }

    public String DeleteUser(Long UserId){
        userrepository.deleteById(UserId);
        return "The User with id "+UserId+" is deleted Successfully!!!";
    }
}
