package com.application.evdekalkodla.dto;


import com.application.evdekalkodla.entity.SubjectStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectUpdateDto {


    private Long id;
    private String description;
    private String details;
    private Date date;
    private SubjectStatus subjectStatus;
    private Long assignee_id;
    private Long project_id;
}
