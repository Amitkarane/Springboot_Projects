package com.vizionexl.LMS.DAO;

import com.vizionexl.LMS.Model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserData, Long> {
}
