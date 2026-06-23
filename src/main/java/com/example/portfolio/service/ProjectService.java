package com.example.portfolio.service;

import com.example.portfolio.entity.Project;

import java.util.*;

public interface ProjectService {

    List<Project> getAllProjects();

    Project addProject(Project project);

    Project updateProject(Long id, Project project);

    void deleteProject(Long id);
}