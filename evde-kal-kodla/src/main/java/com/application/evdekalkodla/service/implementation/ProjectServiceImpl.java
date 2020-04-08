package com.application.evdekalkodla.service.implementation;

import com.application.evdekalkodla.entity.Project;
import com.application.evdekalkodla.repository.ProjectRepository;
import com.application.evdekalkodla.service.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;


    public ProjectServiceImpl (ProjectRepository projectRepository)
    {
        this.projectRepository = projectRepository;
    }


    @Override
    public Project save(Project project) {

        if(project.getProjectCode()== null)
        {
            throw new IllegalArgumentException("Project Code Already Exist");
        }

        return projectRepository.save(project);
    }

    @Override
    public Project getById(Long id) {
        return projectRepository.getOne(id);
    }

    @Override
    public Page<Project> getAllPageable(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(Project project) {

        return null;
    }
}
