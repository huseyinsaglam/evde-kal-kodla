package com.application.evdekalkodla.service.implementation;

import com.application.evdekalkodla.dto.ProjectDto;
import com.application.evdekalkodla.entity.Project;
import com.application.evdekalkodla.repository.ProjectRepository;
import com.application.evdekalkodla.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;


    public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public ProjectDto save(ProjectDto project) {

        // Ayni proje kodu ile birden fazla proje kaydi olusturmamak icin kontrol yaptik..
        Project projectCheck = projectRepository.getByProjectCode(project.getProjectCode());

        if (projectCheck != null) {
            throw new IllegalArgumentException("Project Code Already Exist");
        }
        Project projectData = modelMapper.map(project, Project.class);

        projectData = projectRepository.save(projectData);
        project.setId(projectData.getId());
        return project;

    }

    @Override
    public ProjectDto getById(Long id) {

        Project project = projectRepository.getOne(id);
        ProjectDto projectDto = modelMapper.map(project, ProjectDto.class);
        return projectDto;

    }


    @Override
    public ProjectDto getByProjectCode(String projectCode) {
        return null;
    }

    @Override
    public Page<Project> getAllPageable(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(Project project) {

        return null;
    }

    public Boolean delete(Long id) {
        projectRepository.deleteById(id);
        return true;
    }

    @Override
    public ProjectDto update(Long id, ProjectDto project) {



        Project projectdb = projectRepository.getOne(id);

        if (projectdb == null) {
            throw new IllegalArgumentException("Project Does Not Exist ID:" + id);
        }

        // Ayni proje kodu ile birden fazla proje kaydi olusturmamak icin kontrol yaptik..
        // Proje Kodu su olan (project.getProjectCode() ) ve Id' si suan mevcut duzenlemeye calistigimiz
        // id olmayan ve bize parametre gelen ( projectCheck ) varsa hata ver
        Project projectCheck = projectRepository.getByProjectCodeAndIdNot(project.getProjectCode(), id);

        if (projectCheck != null) {
            throw new IllegalArgumentException("Project Code Already Exist");
        }

        projectdb.setProjectCode(project.getProjectCode());
        projectdb.setProjectName(project.getProjectName());

        projectRepository.save(projectdb);

        return modelMapper.map(projectdb,ProjectDto.class);

    }
}