package com.vizionexl.UserLogin.Repository;

import com.vizionexl.UserLogin.model.userData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<userData, Long> {
    userData findByMailId(String mailId);
}
