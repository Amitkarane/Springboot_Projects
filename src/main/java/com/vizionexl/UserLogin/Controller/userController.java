package com.vizionexl.UserLogin.Controller;

import com.vizionexl.UserLogin.Services.UserService;
import com.vizionexl.UserLogin.model.userData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    private UserService userService;

    @PostMapping
    public userData saveUser(@RequestBody userData user) {
        return userService.saveUser(user);
    }

    @GetMapping
    public List<userData> getAllUser() {
        return userService.getUsers();
    }

    @DeleteMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "The User with the id " + id + " is deleted successfully.";
    }

    @PatchMapping("/updateMail/{id}")
    public userData updateMailId(@PathVariable("id") Long id, @RequestBody userData user) {
        return userService.updateMailId(id, user);
    }

    @PatchMapping("/updatePass/{id}")
    public userData updatePassword(@PathVariable("id") Long id, @RequestBody userData user) {
        return userService.updatePassword(id, user);
    }

    @PostMapping("/login")
    public String login(@RequestBody userData user) {
        boolean isValid = userService.verifyLogin(user.getMailId(), user.getPassword());
        if (isValid) {
            return "User Login Successfully";
        } else {
            return "Invalid email or Password!!!";
        }
    }
}
