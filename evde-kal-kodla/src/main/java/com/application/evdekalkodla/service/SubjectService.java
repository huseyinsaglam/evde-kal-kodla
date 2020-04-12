package com.application.evdekalkodla.service;

import com.application.evdekalkodla.dto.SubjectDto;
import com.application.evdekalkodla.pagination.TPage;
import org.springframework.data.domain.Pageable;


public interface SubjectService {

    public SubjectDto save(SubjectDto subject); // subject verelim kaydetsin sonra geri bize subject kaydini geri donsun..

    public SubjectDto getById(Long id);

    public TPage<SubjectDto> getAllPageable(Pageable pageable); // pageable (sayfalama) seklinde getir butun subject leri..

    // Boolean delete(SubjectDto subject);

    Boolean delete(Long subject);

    SubjectDto update(Long id, SubjectDto subject);
}
