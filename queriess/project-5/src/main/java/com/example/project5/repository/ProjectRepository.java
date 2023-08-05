package com.example.project5.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.project5.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("select q from Project q")
    List<Project> findAllData();
    
    @Query("select q from Project q where q.active=false")
    List<Project> findAlldetail();

    @Query("select q from Project q where q.active=:activeState and q.description in :descriptionList")
    List<Project> findData(@Param("activeState") Boolean activeState, @Param("descriptionList") List<String> descriptionList);
    


    @Modifying
    @Query("update Project q set q.active = ?1 where q.id in ?2")
    int updateData(Boolean activeState, List<Long> idList);


}
