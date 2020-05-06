package com.application.evdekalkodla.dto;

import com.application.evdekalkodla.entity.SubjectStatus;
import lombok.Data;

import java.util.Date;

@Data
public class SubjectHistoryDto {


    private Long id;
    private SubjectDto subject;
    private String description;
    private Date date;
    private SubjectStatus subjectStatus;
    private String details;
    private UserDto assignee;
}
