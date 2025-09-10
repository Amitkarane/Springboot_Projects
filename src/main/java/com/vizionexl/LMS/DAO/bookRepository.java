package com.vizionexl.LMS.DAO;

import com.vizionexl.LMS.Model.Bookdata;
import com.vizionexl.LMS.Model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface bookRepository extends JpaRepository<Bookdata,Integer> {
    Optional<Bookdata> findByBorrowedById(UserData userId);
}
