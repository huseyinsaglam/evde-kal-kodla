package com.application.evdekalkodla.service.implementation;

import com.application.evdekalkodla.dto.ProjectDto;
import com.application.evdekalkodla.entity.Project;
import com.application.evdekalkodla.entity.Subject;
import com.application.evdekalkodla.entity.User;
import com.application.evdekalkodla.pagination.TPage;
import com.application.evdekalkodla.repository.ProjectRepository;
import com.application.evdekalkodla.repository.UserRepository;
import com.application.evdekalkodla.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;


    public ProjectServiceImpl(ProjectRepository projectRepository,
                              ModelMapper modelMapper,
                              UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }


    @Override
    public ProjectDto save(ProjectDto project) {

        // Ayni proje kodu ile birden fazla proje kaydi olusturmamak icin kontrol yaptik..
        Project projectCheck = projectRepository.getByProjectCode(project.getProjectCode());

        if (projectCheck != null) {
            throw new IllegalArgumentException("Project Code Already Exist");
        }
        Project projectData = modelMapper.map(project, Project.class);
        User user = userRepository.getOne(project.getManagerId());
        projectData.setManagerIds(user);

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
    public TPage<ProjectDto> getAllPageable(Pageable pageable) {
        Page<Project> data = projectRepository.findAll(pageable);
        TPage<ProjectDto> response = new TPage<ProjectDto>();
        response.setPage(data, Arrays.asList(modelMapper.map(data.getContent(), ProjectDto[].class)));
        return response;
    }

    public List<ProjectDto> getAll()
    {
        List<Project> data = projectRepository.findAll();
        return Arrays.asList(modelMapper.map(data, ProjectDto[].class));

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
