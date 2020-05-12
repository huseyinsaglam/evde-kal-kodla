package com.application.evdekalkodla.service.implementation;

import com.application.evdekalkodla.dto.SubjectDetailDto;
import com.application.evdekalkodla.dto.SubjectDto;
import com.application.evdekalkodla.dto.SubjectHistoryDto;
import com.application.evdekalkodla.dto.SubjectUpdateDto;
import com.application.evdekalkodla.entity.Subject;
import com.application.evdekalkodla.entity.SubjectStatus;
import com.application.evdekalkodla.entity.User;
import com.application.evdekalkodla.pagination.TPage;
import com.application.evdekalkodla.repository.ProjectRepository;
import com.application.evdekalkodla.repository.SubjectRepository;
import com.application.evdekalkodla.repository.UserRepository;
import com.application.evdekalkodla.service.SubjectHistoryService;
import com.application.evdekalkodla.service.SubjectService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

   /* @Autowired
    private SubjectRepository subjectRepository;*/

    private final SubjectRepository subjectRepository;
    private final ModelMapper modelMapper;
    private final SubjectHistoryImpl subjectHistoryService;
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;


    public SubjectServiceImpl (SubjectRepository subjectRepository,
                               ModelMapper modelMapper,
                               SubjectHistoryImpl subjectHistoryService,
                               UserRepository userRepository,
                               ProjectRepository projectRepository)
    {
        this.subjectRepository = subjectRepository;
        this.modelMapper = modelMapper;
        this.subjectHistoryService=subjectHistoryService;
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
    }


    @Override
    public SubjectDto save(SubjectDto subject) {

/*        if(subject.getDate()==null)
        {
            throw new IllegalArgumentException("Issue Date cannot be null");
        }

        // Disaridan gelen nesneyi (SubjectDto subject ) ilk once Subject nesnesine donustur ve oyle veritabanina kaydet..
        Subject subjectdb = modelMapper.map(subject,Subject.class);
        subjectdb = subjectRepository.save(subjectdb);

        // veri tabanina kaydedilen nesneyi donerken bu seferde SubjectDto donder oyle return yap..
        return modelMapper.map(subjectdb,SubjectDto.class);*/

        subject.setDate(new Date());
        subject.setSubjectStatus(SubjectStatus.OPEN);


        Subject subjectDb = modelMapper.map(subject, Subject.class); // issue ile IssueDto classını Issue class ile eşleştiriyor.. issuDb ile Issue class'ına atadı
        subjectDb.setProjectIds(projectRepository.getOne(subject.getProjectId()));
        subjectDb = subjectRepository.save(subjectDb); // issue veri tabanına kaydetti..
        subject.setId(subjectDb.getId());
        return subject;

    }

    @Override
    public SubjectDto getById(Long id) {
        return null;
    }


    public SubjectDetailDto getByIdWithDetails(Long id) {
        Subject subject = subjectRepository.getOne(id);
        SubjectDetailDto detailDto = modelMapper.map(subject, SubjectDetailDto.class);
        List<SubjectHistoryDto> subjectHistoryDtos = subjectHistoryService.getBySubjectId(subject.getId());
        detailDto.setSubjectHistories(subjectHistoryDtos);
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

    @Transactional
    public SubjectDetailDto update(Long id, SubjectUpdateDto subject) {
        Subject subjectDb = subjectRepository.getOne(id);
        subjectHistoryService.addHistory(id, subjectDb);
        User user = userRepository.getOne(subject.getAssignee_id());


        subjectDb.setAssignee(user);
        subjectDb.setDate(subject.getDate());
        subjectDb.setDescription(subject.getDescription());
        subjectDb.setDetails(subject.getDetails());
        subjectDb.setSubjectStatus(subject.getSubjectStatus());
        subjectDb.setProjectIds(projectRepository.getOne(subject.getProject_id()));
        subjectRepository.save(subjectDb);
        return getByIdWithDetails(id);
    }

    public List<SubjectDto> getAll() {

        List<Subject> data = subjectRepository.findAll();
        return Arrays.asList(modelMapper.map(data, SubjectDto[].class));
    }
}
