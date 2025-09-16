package com.vizionexl.LMS.Controller;

import com.vizionexl.LMS.Model.AdminData;
import com.vizionexl.LMS.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Admin")
public class AdminController {

    @Autowired
    private AdminService adminservice;

    @GetMapping("/getAdmins")
    public List<AdminData> GetAdmins(){
        return adminservice.getAllAdmins();
    }

    @PostMapping("/register")
    public AdminData SaveAdmin(@RequestBody AdminData admin){
        return adminservice.SaveAdmin(admin);
    }

    @DeleteMapping("/delete/{id}")
    public String DeleteAdmin(@PathVariable int id){
        return adminservice.DeleteAdmin(id);
    }

    @PostMapping("/Login")
    public ResponseEntity<Map<String, Object>> Login(@RequestBody AdminData LoginRequest){
        Map<String, Object> result = adminservice.Login(LoginRequest.getMailId(),LoginRequest.getPassword());
        return ResponseEntity.ok(result);
    }
}
