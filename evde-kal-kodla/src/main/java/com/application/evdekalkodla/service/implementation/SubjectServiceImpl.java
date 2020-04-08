package com.application.evdekalkodla.service.implementation;

import com.application.evdekalkodla.dto.SubjectDto;
import com.application.evdekalkodla.entity.Subject;
import com.application.evdekalkodla.pagination.TPage;
import com.application.evdekalkodla.repository.SubjectRepository;
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


    public SubjectServiceImpl (SubjectRepository subjectRepository, ModelMapper modelMapper)
    {
        this.subjectRepository = subjectRepository;
        this.modelMapper = modelMapper;
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

    @Override
    public TPage<SubjectDto> getAllPageable(Pageable pageable) {
        Page<Subject> data = subjectRepository.findAll(pageable);
        TPage<SubjectDto> response = new TPage<SubjectDto>();
        response.setPage(data, Arrays.asList(modelMapper.map(data.getContent(), SubjectDto[].class)));
        return response;

    }
    @Override
    public Boolean delete(SubjectDto subject) {
        return null;
    }
}
