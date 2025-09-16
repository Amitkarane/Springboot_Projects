package com.vizionexl.LMS.DAO;

import com.vizionexl.LMS.Model.AdminData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<AdminData,Integer> {
    AdminData findByMailId(String mailId);
}
