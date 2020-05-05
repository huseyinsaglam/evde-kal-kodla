package com.application.evdekalkodla.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "project")
@Data  /*koymamın sebebi Project getter ve setter'ini yaratmak için*/
@NoArgsConstructor /* bu nesnelerin boş bir constructırını yaratıyor*/
@AllArgsConstructor   /*bu nesnelerin tüm özelliklerini kullanarak kullanılan bir constructordır*/
@ToString  /* özelliklerin ekrana yazılması için tostring metodunu override ediyoruz..*/
@EqualsAndHashCode
public class Project extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "project_name", length = 300)
    private String projectName;

    @Column(name = "project_code", length = 30)
    private String projectCode;


    @JoinColumn(name = "manager_user_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)  /*Her bir projenin bir user manageri olsun..*/
    private User managerId;

}
