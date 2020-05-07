package com.application.evdekalkodla.api;



import com.application.evdekalkodla.dto.SubjectDetailDto;
import com.application.evdekalkodla.dto.SubjectDto;
import com.application.evdekalkodla.entity.SubjectStatus;
import com.application.evdekalkodla.pagination.TPage;
import com.application.evdekalkodla.service.implementation.SubjectServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/subject")
@CrossOrigin
public class SubjectController {

    private final SubjectServiceImpl subjectServiceImpl;

    public SubjectController(SubjectServiceImpl subjectServiceImpl) {
        this.subjectServiceImpl = subjectServiceImpl;
    }

    @GetMapping("/pagination")
    public ResponseEntity<TPage<SubjectDto>> getAllPagination(Pageable pageable)
    {
        TPage<SubjectDto> data = subjectServiceImpl.getAllPageable(pageable);
        return ResponseEntity.ok(data);
    }


    @GetMapping("/statuses")
    public ResponseEntity<List<SubjectStatus>> getAll() {
        return ResponseEntity.ok(Arrays.asList(SubjectStatus.values()));
    }



    @GetMapping("/{id}")
    public ResponseEntity<SubjectDto> getByid(@PathVariable("id") Long id)
    {
        SubjectDto subjectDto = subjectServiceImpl.getById(id);
        return ResponseEntity.ok(subjectDto);
    }


    @GetMapping("/detail/{id}")
    public ResponseEntity<SubjectDetailDto> getByIdWithDetails(@PathVariable(value = "id", required = true) Long id) {
        SubjectDetailDto detailDto = subjectServiceImpl.getByIdWithDetails(id);
        return ResponseEntity.ok(detailDto);
    }

    @PostMapping
    public ResponseEntity<SubjectDto> createProject(@Valid @RequestBody SubjectDto subject) {

        return ResponseEntity.ok(subjectServiceImpl.save(subject));

    }



    @PutMapping("/{id}")
    public ResponseEntity<SubjectDto> updateProject(@PathVariable(value = "id") Long id, @Valid @RequestBody SubjectDto subject) {
        return ResponseEntity.ok(subjectServiceImpl.update(id, subject));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(subjectServiceImpl.delete(id));

    }
}
