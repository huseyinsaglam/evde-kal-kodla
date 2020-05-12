package com.application.evdekalkodla.service.implementation;

import com.application.evdekalkodla.dto.SubjectHistoryDto;
import com.application.evdekalkodla.entity.Subject;
import com.application.evdekalkodla.entity.SubjectHistory;
import com.application.evdekalkodla.pagination.TPage;
import com.application.evdekalkodla.repository.SubjectHistoryRepository;
import com.application.evdekalkodla.service.SubjectHistoryService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SubjectHistoryImpl implements SubjectHistoryService {

    private final SubjectHistoryRepository subjectHistoryRepository;
    private final ModelMapper modelMapper;



    public SubjectHistoryImpl(SubjectHistoryRepository subjectHistoryRepository,ModelMapper modelMapper) {
                   this.subjectHistoryRepository =  subjectHistoryRepository;
                   this.modelMapper = modelMapper;

    }

    @Override
    public SubjectHistoryDto save(SubjectHistoryDto subjectHistory) {

        SubjectHistory sh = modelMapper.map(subjectHistory, SubjectHistory.class);
        sh = subjectHistoryRepository.save(sh);
        subjectHistory.setId(sh.getId());
        return subjectHistory;
    }

    @Override
    public SubjectHistoryDto getById(Long id) {

        SubjectHistory ih = subjectHistoryRepository.getOne(id);
        return modelMapper.map(ih, SubjectHistoryDto.class);
    }

    @Override
    public List<SubjectHistoryDto> getBySubjectId(Long id) {
        List<SubjectHistory> subjectHistory = subjectHistoryRepository.getBySubjectIdOrderById(id);
        SubjectHistoryDto[] subjectHistoryDto = modelMapper.map(subjectHistoryRepository.getBySubjectIdOrderById(id), SubjectHistoryDto[].class);
        return Arrays.asList(modelMapper.map(subjectHistoryRepository.getBySubjectIdOrderById(id), SubjectHistoryDto[].class));
    }



    @Override
    public TPage<SubjectHistoryDto> getAllPageable(Pageable pageable) {

        Page<SubjectHistory> data = subjectHistoryRepository.findAll(pageable);
        TPage<SubjectHistoryDto> response = new TPage<SubjectHistoryDto>();
        response.setPage(data, Arrays.asList(modelMapper.map(data.getContent(), SubjectHistoryDto[].class)));
        return response;
    }


    @Override
    public Boolean delete(SubjectHistoryDto subjectHistory) {

        /*Long removeid= subjectHistory.getId();
        SubjectHistory removeSubjectHistory =  getById(removeid);
        subjectHistoryRepository.delete(removeSubjectHistory);*/

        subjectHistoryRepository.deleteById(subjectHistory.getId());
        return Boolean.TRUE;
    }

    @Override
    public void addHistory(Long id, Subject subjectDb) {

        SubjectHistory history=new SubjectHistory();
        history.setSubject(subjectDb);
        history.setAssignee(subjectDb.getAssignee());
        history.setDate(subjectDb.getDate());
        history.setDescription(subjectDb.getDescription());
        history.setDetails(subjectDb.getDetails());
        history.setSubjectStatus(subjectDb.getSubjectStatus());
        subjectHistoryRepository.save(history);
    }
}
