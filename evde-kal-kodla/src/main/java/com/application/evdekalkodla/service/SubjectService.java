package com.application.evdekalkodla.service;

import com.application.evdekalkodla.entity.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SubjectService {

    public Subject save(Subject subject); // subject verelim kaydetsin sonra geri bize subject kaydini geri donsun..

    public Subject getById(Long id);

    public Page<Subject> getAllPageable(Pageable pageable); // pageable (sayfalama) seklinde getir butun subject leri..

}
