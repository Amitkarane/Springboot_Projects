package com.vizionexl.LMS.Service;


import com.vizionexl.LMS.DAO.AdminRepository;
import com.vizionexl.LMS.Model.AdminData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminService {

    @Autowired
    private AdminRepository AdminRepo;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public List<AdminData> getAllAdmins(){
        return AdminRepo.findAll(Sort.by(Sort.Direction.ASC,"id"));
    }

    public AdminData SaveAdmin(AdminData admin){
        String EncodedPassword= passwordEncoder.encode(admin.getPassword());
        admin.setPassword(EncodedPassword);
        return AdminRepo.save(admin);
    }

    public String DeleteAdmin(int id){
        AdminRepo.deleteById(id);
        return "The Admin with Id "+ id +" is deleted Successfully!!!";
    }

    public Map<String, Object> Login(String mailId, String RawPassword){
        Map<String, Object> response=new HashMap<>();
        AdminData admin = AdminRepo.findByMailId(mailId);

        if(admin==null){
            response.put("Success",false);
            response.put("message","User Not Found!!!Try Again!!!");

            return response;
        }

        if(passwordEncoder.matches(RawPassword,admin.getPassword())){
            response.put("Success",true);
            response.put("message","Admin Login Successfully!!!");
            response.put("AdminId", admin.getId());
            response.put("mailId", admin.getMailId());
        }else{
            response.put("Success",false);
            response.put("message","Invalid mailId or Password !!! Try Again !!!");
        }

        return response;
    }

}
