package com.application.evdekalkodla.api;



import com.application.evdekalkodla.dto.SubjectDto;
import com.application.evdekalkodla.service.implementation.SubjectServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/subject")
@CrossOrigin
public class SubjectController {

    private final SubjectServiceImpl subjectServiceImpl;

    public SubjectController(SubjectServiceImpl subjectServiceImpl) {
        this.subjectServiceImpl = subjectServiceImpl;
    }


    @GetMapping("/{id}")
    public ResponseEntity<SubjectDto> getByid(@PathVariable("id") Long id)
    {
        SubjectDto subjectDto = subjectServiceImpl.getById(id);
        return ResponseEntity.ok(subjectDto);
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
