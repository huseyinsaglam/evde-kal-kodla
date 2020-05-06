package com.application.evdekalkodla.service;

import com.application.evdekalkodla.dto.SubjectHistoryDto;
import com.application.evdekalkodla.entity.SubjectHistory;
import com.application.evdekalkodla.pagination.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SubjectHistoryService {

    public SubjectHistoryDto save(SubjectHistoryDto subjectHistory); // subjectHistory verelim kaydetsin sonra geri bize subjectHistory kaydini geri donsun..

    public SubjectHistoryDto getById(Long id);

    List<SubjectHistoryDto> getBySubjectId(Long id);

    public TPage<SubjectHistoryDto> getAllPageable(Pageable pageable); // pageable (sayfalama) seklinde getir butun subjectHistory leri..

    Boolean delete(SubjectHistoryDto subjectHistory);
}
