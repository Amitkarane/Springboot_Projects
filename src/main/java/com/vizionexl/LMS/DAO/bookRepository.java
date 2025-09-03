package com.vizionexl.LMS.DAO;

import com.vizionexl.LMS.Model.Bookdata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface bookRepository extends JpaRepository<Bookdata,Integer> {
}
