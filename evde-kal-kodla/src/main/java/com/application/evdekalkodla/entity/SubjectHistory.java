package com.application.evdekalkodla.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "subjecthistory")
@Data // koymamın sebebi SubjectHistory getter ve setter'ini yaratmak için
@NoArgsConstructor // bu nesnelerin boş bir constructırını yaratıyor
@AllArgsConstructor // bu nesnelerin tüm özelliklerini kullanarak kullanılan bir constructordır
@ToString // özelliklerin ekrana yazılması için tostring metodunu override ediyoruz..
@EqualsAndHashCode // equals ve hash code metotlarını override ediyoruz..
public class SubjectHistory extends BaseEntity { // burada history'in bir geçmişi olsun..
    // burada history in geçmisini tutuyoruz önce açıldı sonra kapatıldı , resolved oldu gibi subject geçmişini tutuyoruz..

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /*@JoinColumn(name = "subjectid")*/
    @JoinColumn(name = "subject_id")
    @ManyToOne(optional = true , fetch = FetchType.LAZY)
    private Subject subject;

    @Column(name = "description" , length = 1000)
    private String description;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private Date date;


    @Column(name = "details" , length = 4000)
    private String details;

    /* @Column(name = "subjectstatus")*/
    @Column(name = "subject_status")
    @Enumerated(EnumType.STRING)
    private SubjectStatus subjectStatus;

    @JoinColumn(name = "assignee_user_id")
    /*@JoinColumn(name = "assigneeuserid")*/
    @ManyToOne(optional = true , fetch = FetchType.LAZY)
    private User assignee;
}
