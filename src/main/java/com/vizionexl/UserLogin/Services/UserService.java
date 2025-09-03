package com.vizionexl.UserLogin.Services;

import com.vizionexl.UserLogin.Repository.userRepository;
import com.vizionexl.UserLogin.model.userData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private userRepository userrepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public List<userData> getUsers() {
        return userrepository.findAll();
    }

    public userData saveUser(userData user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userrepository.save(user);
    }

    public String deleteUser(Long id) {
        userrepository.deleteById(id);
        return "The user with id " + id + " is deleted successfully";
    }

    public userData updateMailId(Long id, userData user) {
        Optional<userData> optional = userrepository.findById(id);
        userData savedData = optional.get();

        if (user.getMailId() != null) {
            savedData.setMailId(user.getMailId());
        }
        return userrepository.save(savedData);
    }

    public userData updatePassword(Long id, userData user) {
        Optional<userData> optional = userrepository.findById(id);
        userData savedData = optional.get();

        if (user.getPassword() != null) {
            savedData.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        return userrepository.save(savedData);
    }

    public boolean verifyLogin(String mailId, String password) {
        userData user = userrepository.findByMailId(mailId);
        return user != null && passwordEncoder.matches(password, user.getPassword());
    }
}
