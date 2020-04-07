package com.application.evdekalkodla.repository;

import com.application.evdekalkodla.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {


    //List<Project> findAllByProjectCode(String projectCode);
    // üsteki yazımın yerine springdata bunu anlıyor  ve getAllByProjectCode ile Project classında map ediyor ve işlemlerini yapıyor


    Project getByProjectCode(String projectCode);

    Project getByProjectCodeAndIdNot(String projectCode, Long id);

    List<Project> getByProjectCodeContains(String projectCode);

    Page<Project> findAll(Pageable pageable);

    List<Project> findAll(Sort sort);
}
