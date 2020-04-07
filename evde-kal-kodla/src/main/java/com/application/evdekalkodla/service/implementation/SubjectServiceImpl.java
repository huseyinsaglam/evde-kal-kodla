package com.application.evdekalkodla.service.implementation;

import com.application.evdekalkodla.entity.Subject;
import com.application.evdekalkodla.repository.SubjectRepository;
import com.application.evdekalkodla.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class SubjectServiceImpl implements SubjectService {

   /* @Autowired
    private SubjectRepository subjectRepository;*/

    private final SubjectRepository subjectRepository;


    public SubjectServiceImpl (SubjectRepository subjectRepository)
    {
        this.subjectRepository = subjectRepository;
    }


    @Override
    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Subject getById(Long id) {
        return subjectRepository.getOne(id);
    }

    @Override
    public Page<Subject> getAllPageable(Pageable pageable) {
        return subjectRepository.findAll(pageable);
    }
}
