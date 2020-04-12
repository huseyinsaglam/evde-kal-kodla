package com.application.evdekalkodla.service;

import com.application.evdekalkodla.dto.ProjectDto;
import com.application.evdekalkodla.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectService {

    public ProjectDto save(ProjectDto project); // Project verelim kaydetsin sonra geri bize Project kaydini geri donsun..

    public ProjectDto getById(Long id);

    ProjectDto getByProjectCode(String projectCode);

    public Page<Project> getAllPageable(Pageable pageable); // pageable (sayfalama) seklinde getir butun Project leri..

    Boolean delete(Project project);

    public ProjectDto update(Long id,ProjectDto project);

}
