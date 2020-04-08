package com.application.evdekalkodla.service.implementation;

import com.application.evdekalkodla.entity.SubjectHistory;
import com.application.evdekalkodla.repository.SubjectHistoryRepository;
import com.application.evdekalkodla.service.SubjectHistoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SubjectHistoryImpl implements SubjectHistoryService {

    private final SubjectHistoryRepository subjectHistoryRepository;


    public SubjectHistoryImpl(SubjectHistoryRepository subjectHistoryRepository) {
                   this.subjectHistoryRepository =  subjectHistoryRepository;
    }

    @Override
    public SubjectHistory save(SubjectHistory subjectHistory) {
        if (subjectHistory.getDate()==null)
        {
                throw new IllegalArgumentException("Subject cannot be null");
        }

        return subjectHistoryRepository.save(subjectHistory);
    }

    @Override
    public SubjectHistory getById(Long id) {
        return subjectHistoryRepository.getOne(id);
    }

    @Override
    public Page<SubjectHistory> getAllPageable(Pageable pageable) {
        return subjectHistoryRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(SubjectHistory subjectHistory) {

        /*Long removeid= subjectHistory.getId();
        SubjectHistory removeSubjectHistory =  getById(removeid);
        subjectHistoryRepository.delete(removeSubjectHistory);*/

        subjectHistoryRepository.delete(subjectHistory);
        return Boolean.TRUE;
    }
}
