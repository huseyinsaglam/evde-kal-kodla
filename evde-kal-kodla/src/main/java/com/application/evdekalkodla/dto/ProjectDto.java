package com.application.evdekalkodla.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {



    private Long id;
    private String projectName;
    private String projectCode;
    // private Long managerId;
   /*
    private UserDto  manager;*/
}
