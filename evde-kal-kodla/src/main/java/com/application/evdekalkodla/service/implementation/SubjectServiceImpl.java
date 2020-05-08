package com.application.evdekalkodla.service.implementation;

import com.application.evdekalkodla.dto.SubjectDetailDto;
import com.application.evdekalkodla.dto.SubjectDto;
import com.application.evdekalkodla.dto.SubjectHistoryDto;
import com.application.evdekalkodla.dto.SubjectUpdateDto;
import com.application.evdekalkodla.entity.Subject;
import com.application.evdekalkodla.pagination.TPage;
import com.application.evdekalkodla.repository.SubjectRepository;
import com.application.evdekalkodla.service.SubjectHistoryService;
import com.application.evdekalkodla.service.SubjectService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

   /* @Autowired
    private SubjectRepository subjectRepository;*/

    private final SubjectRepository subjectRepository;
    private final ModelMapper modelMapper;
    private final SubjectHistoryService subjectHistoryService;


    public SubjectServiceImpl (SubjectRepository subjectRepository,
                               ModelMapper modelMapper,
                               SubjectHistoryService subjectHistoryService)
    {
        this.subjectRepository = subjectRepository;
        this.modelMapper = modelMapper;
        this.subjectHistoryService=subjectHistoryService;
    }


    @Override
    public SubjectDto save(SubjectDto subject) {

        if(subject.getDate()==null)
        {
            throw new IllegalArgumentException("Issue Date cannot be null");
        }

        // Disaridan gelen nesneyi (SubjectDto subject ) ilk once Subject nesnesine donustur ve oyle veritabanina kaydet..
        Subject subjectdb = modelMapper.map(subject,Subject.class);
        subjectdb = subjectRepository.save(subjectdb);

        // veri tabanina kaydedilen nesneyi donerken bu seferde SubjectDto donder oyle return yap..
        return modelMapper.map(subjectdb,SubjectDto.class);

    }

    @Override
    public SubjectDto getById(Long id) {
        return null;
    }


    public SubjectDetailDto getByIdWithDetails(Long id) {
        Subject subject = subjectRepository.getOne(id);
        SubjectDetailDto detailDto = modelMapper.map(subject, SubjectDetailDto.class);
        List<SubjectHistoryDto> issueHistoryDtos = subjectHistoryService.getBySubjectId(subject.getId());
        detailDto.setSubjectHistories(issueHistoryDtos);
        return detailDto;
    }

    @Override
    public TPage<SubjectDto> getAllPageable(Pageable pageable) {
        Page<Subject> data = subjectRepository.findAll(pageable);
        TPage<SubjectDto> response = new TPage<SubjectDto>();
        response.setPage(data, Arrays.asList(modelMapper.map(data.getContent(), SubjectDto[].class)));
        return response;

    }
    @Override
    public Boolean delete(Long subjectId) {
        subjectRepository.deleteById(subjectId);
        return true;
    }

    @Override
    public SubjectDetailDto update(Long id, SubjectUpdateDto subject) {
        return null;
    }

    public List<SubjectDto> getAll() {

        List<Subject> data = subjectRepository.findAll();
        return Arrays.asList(modelMapper.map(data, SubjectDto[].class));
    }
}
