package com.example.project5.service; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project5.model.Project;
import com.example.project5.repository.ProjectRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public List<Project> getTableDatas() {
        return projectRepository.findAllData();
    }
    
    public List<Project> getDetail(Boolean activeState, List<String> descriptionList){
        return projectRepository.findData(activeState, descriptionList);
    }

    public List<Project> getTableData() {
        return projectRepository.findAlldetail();
    }

    public int updateDatas(Boolean activeState, List<Long> idList) {
        return projectRepository.updateData(activeState, idList);
    }
}
