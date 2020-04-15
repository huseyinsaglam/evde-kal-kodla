package com.application.evdekalkodla.api;


import com.application.evdekalkodla.dto.ProjectDto;
import com.application.evdekalkodla.pagination.TPage;
import com.application.evdekalkodla.service.implementation.ProjectServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/project")
public class ProjectController {

    private final ProjectServiceImpl projectServiceImpl;


    public ProjectController(ProjectServiceImpl projectServiceImpl) {
        this.projectServiceImpl = projectServiceImpl;
    }

    // Url deki gelen id'i PathVariable ile aldık ...
    @GetMapping("/{id}") // REST Web Servis metodu haline getirmek için
    public ResponseEntity<ProjectDto> getByid(@PathVariable("id") Long id)
    {
        ProjectDto projectDto = projectServiceImpl.getById(id);
        return ResponseEntity.ok(projectDto);
    }

    @GetMapping("/pagination")
    public ResponseEntity<TPage<ProjectDto>> getAllPagination(Pageable pageable)
    {
        TPage<ProjectDto> data = projectServiceImpl.getAllPageable(pageable);
        return ResponseEntity.ok(data);
    }

    @PostMapping
    public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto project)
    {

        return ResponseEntity.ok(projectServiceImpl.save(project));

    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectDto> updateProject (@PathVariable("id") Long id, @Valid @RequestBody ProjectDto project)
    {
        return ResponseEntity.ok(projectServiceImpl.update(id,project));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id)
    {
        return ResponseEntity.ok(projectServiceImpl.delete(id));

    }
}
