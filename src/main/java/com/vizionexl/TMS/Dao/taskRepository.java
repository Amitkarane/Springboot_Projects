package com.vizionexl.TMS.Dao;

import com.vizionexl.TMS.Model.taskData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface taskRepository extends JpaRepository<taskData,Integer> {
}
