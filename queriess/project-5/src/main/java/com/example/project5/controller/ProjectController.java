package com.example.project5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project5.model.Project;
import com.example.project5.service.ProjectService;

@RestController
@RequestMapping("/api")

public class ProjectController {
    
    @Autowired
    ProjectService projectService;

    @GetMapping("/show_all")
    public List<Project> getDetails(){
        return projectService.getTableDatas();
    }
    
    @GetMapping("/show_data")
    public List<Project> getDetail(){
        return projectService.getTableData();
    }
    
    @GetMapping("/show_data/{activeState}/{descriptionList}")
    public List<Project> getData(@PathVariable Boolean activeState, @PathVariable List<String> descriptionList){
        return projectService.getDetail(activeState, descriptionList);
    }

    @PutMapping("/updateData/{activeState}/{idList}")
    public int updateData(@PathVariable Boolean activeState, @PathVariable List<Long> idList){
        return projectService.updateDatas(activeState, idList);
    }

}
