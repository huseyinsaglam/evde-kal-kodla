package com.application.evdekalkodla.dto;

import com.application.evdekalkodla.entity.SubjectStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDetailDto {



    private Long id;
    private String description;
    private String details;
    private Date date;
    private SubjectStatus subjectStatus;
    private UserDto assignee;
    private ProjectDto project;
    private List<SubjectHistoryDto> subjectHistories;
}
