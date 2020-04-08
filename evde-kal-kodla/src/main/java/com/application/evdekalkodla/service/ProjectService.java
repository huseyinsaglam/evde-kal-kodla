package com.application.evdekalkodla.service;

import com.application.evdekalkodla.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectService {

    public Project save(Project project); // Project verelim kaydetsin sonra geri bize Project kaydini geri donsun..

    public Project getById(Long id);

    public Page<Project> getAllPageable(Pageable pageable); // pageable (sayfalama) seklinde getir butun Project leri..

    Boolean delete(Project project);

}
