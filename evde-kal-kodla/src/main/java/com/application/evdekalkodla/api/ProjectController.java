package com.application.evdekalkodla.api;


import com.application.evdekalkodla.dto.ProjectDto;
import com.application.evdekalkodla.pagination.TPage;
import com.application.evdekalkodla.service.implementation.ProjectServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/project")
@Tag(name = "project", description = "The Project APi")
@CrossOrigin
public class ProjectController {

    // http://localhost:8080/project/4
    private final ProjectServiceImpl projectServiceImpl;


    public ProjectController(ProjectServiceImpl projectServiceImpl) {
        this.projectServiceImpl = projectServiceImpl;
    }


    // Url deki gelen id'i PathVariable ile aldık ...
    @Operation(
            summary = "Get By id ProjectDto Operations",
            description = "Get By id ProjectDto Operations",
            tags = "ProjectDto"
    )

    @GetMapping(value = "/{id}",produces = "application/json") // REST Web Servis metodu haline getirmek için
    public ResponseEntity<ProjectDto> getByid(@PathVariable("id") Long id)
    {
        ProjectDto projectDto = projectServiceImpl.getById(id);
        return ResponseEntity.ok(projectDto);
    }


    @Operation(
            summary = "Get By Pagination ProjectDto Operation",
            description = "Get By Pagination ProjectDto Operation",
            tags = "ProjectDto"
    )

    @GetMapping(value = "/pagination" , produces = "application/json")
    public ResponseEntity<TPage<ProjectDto>> getAllPagination(Pageable pageable)
    {
        TPage<ProjectDto> data = projectServiceImpl.getAllPageable(pageable);
        return ResponseEntity.ok(data);
    }

    @Operation(
            summary = "Get All ProjectDto Operation",
            description = "Get All ProjectDto Operation",
            tags = "ProjectDto"
    )

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<ProjectDto>> getAll()
    {
        List<ProjectDto> data = projectServiceImpl.getAll();
        return ResponseEntity.ok(data);
    }


    @Operation(
            summary = "Create Operations ProjectDto",
            description = "Create Operations ProjectDto",
            tags = "ProjectDto"
    )
    @PostMapping(produces = "application/json")
    public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto project)
    {

        return ResponseEntity.ok(projectServiceImpl.save(project));

    }

    @Operation(
            summary = "Update Operations ProjectDto",
            description = "Update Operations ProjectDto",
            tags = "ProjectDto"
    )
    @PutMapping(value = "/{id}",produces = "application/json")
    public ResponseEntity<ProjectDto> updateProject (@PathVariable("id") Long id, @Valid @RequestBody ProjectDto project)
    {
        return ResponseEntity.ok(projectServiceImpl.update(id,project));
    }

    @Operation(
            summary = "Delete Operations ProjectDto",
            description = "Delete Operations ProjectDto",
            tags = "ProjectDto"
    )
    @DeleteMapping(value = "/{id}",produces = "application/json")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id)
    {
        return ResponseEntity.ok(projectServiceImpl.delete(id));

    }
}
