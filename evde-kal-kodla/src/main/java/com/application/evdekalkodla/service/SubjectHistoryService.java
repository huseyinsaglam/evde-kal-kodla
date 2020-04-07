package com.application.evdekalkodla.service;

import com.application.evdekalkodla.entity.SubjectHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SubjectHistoryService {

    public SubjectHistory save(SubjectHistory subjectHistory); // subjectHistory verelim kaydetsin sonra geri bize subjectHistory kaydini geri donsun..

    public SubjectHistory getById(Long id);

    public Page<SubjectHistory> getAllPageable(Pageable pageable); // pageable (sayfalama) seklinde getir butun subjectHistory leri..
}
