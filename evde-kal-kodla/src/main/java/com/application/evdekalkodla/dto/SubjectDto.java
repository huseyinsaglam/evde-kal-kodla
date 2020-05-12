package com.application.evdekalkodla.dto;

import com.application.evdekalkodla.entity.SubjectStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDto {



    private Long id;
    private String description;
    private String details;
    private Date date;
    private SubjectStatus subjectStatus;
    private UserDto assignee;


    private Long projectId;

    private ProjectDto projectIds;


}
